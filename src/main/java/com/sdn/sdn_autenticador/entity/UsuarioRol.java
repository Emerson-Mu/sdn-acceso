package com.sdn.sdn_autenticador.entity;

public class UsuarioRol {

    private int idUsuario;
    private int idCredencial;
    private String varUsCorreo;
    private String roles;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCredencial() {
        return idCredencial;
    }

    public void setIdCredencial(int idCredencial) {
        this.idCredencial = idCredencial;
    }

    public String getVarUsCorreo() {
        return varUsCorreo;
    }

    public void setVarUsCorreo(String varUsCorreo) {
        this.varUsCorreo = varUsCorreo;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
