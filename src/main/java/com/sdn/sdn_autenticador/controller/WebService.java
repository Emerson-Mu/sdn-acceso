package com.sdn.sdn_autenticador.controller;

import com.sdn.sdn_autenticador.entity.Credencial;
import com.sdn.sdn_autenticador.entity.Rol;
import com.sdn.sdn_autenticador.entity.Usuario;
import com.sdn.sdn_autenticador.entity.UsuarioJson;
import com.sdn.sdn_autenticador.service.CredencialService;
import com.sdn.sdn_autenticador.service.RolService;
import com.sdn.sdn_autenticador.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class WebService {

    private final UsuarioService usuarioService;
    private final CredencialService credencialService;
    private final RolService rolService;

    public WebService(CredencialService credencialService, UsuarioService usuarioService, RolService rolService){
        this.usuarioService = usuarioService;
        this.credencialService = credencialService;
        this.rolService = rolService;
    }

    @GetMapping("/servicio_test")
    public ResponseEntity servicioTest(){
        return new ResponseEntity("Servicio Web funcionando", HttpStatus.OK);
    }

    @GetMapping(value="/listarCredenciales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity servicioListarUsuarios(){
        List<Credencial> listaCredenciales = credencialService.listaCredenciales();
        return new ResponseEntity(listaCredenciales, HttpStatus.OK);
    }

    @GetMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity validarCredencial(@RequestParam(value = "usuario",defaultValue = "") String usuario,
                                              @RequestParam(value = "contrasenia",defaultValue = "") String contrasenia){

        HashMap<String,String> responseMap = new HashMap<>();
        //UsuarioJson
        UsuarioJson usuarioJson = new UsuarioJson();
        if(usuario.equals("") || contrasenia.equals("")){
            responseMap.put("msg","credenciales vacias");
            return new ResponseEntity<>(responseMap,HttpStatus.UNAUTHORIZED);
        }else{
            List<Credencial> listaCredenciales = credencialService.listaCredenciales();

            for(Credencial crd1 : listaCredenciales){
                if(crd1.getVarUsCorreo().equals(usuario)){
                    if(crd1.getVarUsPassword().equals(contrasenia)){
                        //Credenciales exitosas
                        //responseMap.put("msg","logueo exitoso");
                        usuarioJson.setMsg("logueo exitoso");
                        //Buscar usuario con la credencial referida
                        List<Usuario> listaUsuarioCredencial = new ArrayList<>();
                        List<Usuario> listaUsuarios = usuarioService.listaUsuarios();
                        for(Usuario us1 : listaUsuarios){
                            if(us1.getCredencialIntIdCredencial()== crd1.getIntIdCrd()){
                                listaUsuarioCredencial.add(us1);
                            }
                        }
                        //Buscar los roles de los usuarios encontrados
                        List<String> listaRoles = new ArrayList<>();
                        if(!listaUsuarioCredencial.isEmpty()){
                            for(Usuario us2: listaUsuarioCredencial){
                                Optional<Rol> rolOptional = rolService.buscarRolPorId(us2.getRolIntIdRol());
                                listaRoles.add(rolOptional.get().getVarRolNombre());
                            }
                        usuarioJson.setRoles(listaRoles);
                        }
                        return new ResponseEntity<>(usuarioJson,HttpStatus.OK);
                    }else{
                        //Contraseña erronea
                        responseMap.put("msg","contraseña erronea");
                        return new ResponseEntity<>(responseMap,HttpStatus.UNAUTHORIZED);
                    }
                }
            }
            //Usuario inexistente
            responseMap.put("msg","credenciales erroneas");
            return new ResponseEntity<>(responseMap,HttpStatus.UNAUTHORIZED);
        }

    }



}
