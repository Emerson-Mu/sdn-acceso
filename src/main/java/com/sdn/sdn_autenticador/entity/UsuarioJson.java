package com.sdn.sdn_autenticador.entity;

import java.util.List;

public class UsuarioJson {

    private String msg;
    private List<String> roles;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
