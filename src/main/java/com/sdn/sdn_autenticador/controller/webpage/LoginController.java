package com.sdn.sdn_autenticador.controller.webpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logueo")
public class LoginController {

    @GetMapping(value = {"/inicio"})
    public String signIn(){
        return "login/inicioSesion";
    }

}
