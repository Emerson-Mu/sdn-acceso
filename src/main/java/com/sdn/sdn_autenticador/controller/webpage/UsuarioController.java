package com.sdn.sdn_autenticador.controller.webpage;


import com.sdn.sdn_autenticador.entity.Credencial;
import com.sdn.sdn_autenticador.entity.Usuario;
import com.sdn.sdn_autenticador.service.CredencialService;
import com.sdn.sdn_autenticador.service.RolService;
import com.sdn.sdn_autenticador.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        List<Credencial> listaCredencial = credencialService.listaCredenciales();
        model.addAttribute("listaCrededenciales", listaCredencial);

        return "usuario/lista";
    }
}
