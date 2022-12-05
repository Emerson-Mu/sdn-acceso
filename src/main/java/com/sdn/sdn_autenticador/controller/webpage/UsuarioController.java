package com.sdn.sdn_autenticador.controller.webpage;


import com.sdn.sdn_autenticador.entity.Credencial;
import com.sdn.sdn_autenticador.entity.Rol;
import com.sdn.sdn_autenticador.entity.Usuario;
import com.sdn.sdn_autenticador.entity.UsuarioRol;
import com.sdn.sdn_autenticador.service.CredencialService;
import com.sdn.sdn_autenticador.service.RolService;
import com.sdn.sdn_autenticador.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final CredencialService credencialService;
    private final RolService rolService;

    public UsuarioController(CredencialService credencialService, UsuarioService usuarioService, RolService rolService){
        this.usuarioService = usuarioService;
        this.credencialService = credencialService;
        this.rolService = rolService;
    }

    @GetMapping(value = {"/lista"})
    public String listaUsuariosCredenciales(Model model){
        //Lista credencial, un correo por credencial
        List<Credencial> listaCredencial = credencialService.listaCredenciales();
        //Lista Usuario, uno por Rol
        List<Usuario> listaUsuarios = usuarioService.listaUsuarios();

        //Unir roles con las credencia
        List<UsuarioRol> listaUsuarioRol = new ArrayList<>();
        for(Credencial crd1 : listaCredencial){

            UsuarioRol usuarioRol = new UsuarioRol();

            usuarioRol.setIdUsuario(crd1.getIntIdCrd());
            usuarioRol.setVarUsCorreo(crd1.getVarUsCorreo());

            int idCrd1 = crd1.getIntIdCrd();
            String roles = "";
            for(Usuario us1 : listaUsuarios){
                if(us1.getCredencialIntIdCredencial()==idCrd1){
                    Rol rol1 = rolService.buscarRolPorId(us1.getRolIntIdRol()).get();
                    usuarioRol.setIdCredencial(idCrd1);
                    String rolName = rol1.getVarRolNombre();
                    if(roles.equals("")){
                        roles = roles+rolName;
                    }else{
                        roles = roles + ", " + rolName;
                    }
                }
            }
            usuarioRol.setRoles(roles);
            listaUsuarioRol.add(usuarioRol);
        }
        model.addAttribute("listaUsuarioRol", listaUsuarioRol);

        return "usuario/lista";
    }

    @GetMapping(value={"/nuevo"})
    public String nuevoUsuario(Model model, @ModelAttribute("credencial") Credencial credencial,
                               @ModelAttribute("usuario") Usuario usuario,@ModelAttribute("rol") Rol rol){
        List<Rol> listaRoles = rolService.listaRoles();
        model.addAttribute("listaRoles",listaRoles);
        return "usuario/nuevoUsuario";
    }

    @GetMapping(value={"/editar"})
    public String editarUsuario(@RequestParam("id") int id,@ModelAttribute("credencial") Credencial credencial,
                                Model model){
        List<Rol> listaRoles = rolService.listaRoles();
        Optional<Credencial> crd1 = credencialService.buscarCredencialPorId(id);
        if(crd1.isPresent()){
            Credencial credencial1 = crd1.get();
            model.addAttribute("credencial",credencial1);

            model.addAttribute("listaRoles",listaRoles);
        }

        return "usuario/editarUsuario";
    }

    @PostMapping(value = {"/guardar"})
    public String guardarNuevoUsuario(Model model, @ModelAttribute("credencial") Credencial credencial,
                                      RedirectAttributes attr, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //Error al actualizar/crear los datos
        }else{
            if(credencial.getIntIdCrd() == 0){
                //Credencial creada correctamente
            }else{
                //Credencial actualizada correctamente
            }
            credencialService.guardarCredencial(credencial);
        }
        return "redirect:/usuarios/lista";
    }

}
