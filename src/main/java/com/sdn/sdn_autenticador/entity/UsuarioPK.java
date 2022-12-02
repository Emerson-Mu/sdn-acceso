package com.sdn.sdn_autenticador.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class UsuarioPK implements Serializable {
    @Column(name = "int_id_usuario")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intIdUsuario;
    @Column(name = "credencial_int_id_credencial")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int credencialIntIdCredencial;
    @Column(name = "rol_int_id_rol")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rolIntIdRol;

    public int getIntIdUsuario() {
        return intIdUsuario;
    }

    public void setIntIdUsuario(int intIdUsuario) {
        this.intIdUsuario = intIdUsuario;
    }

    public int getCredencialIntIdCredencial() {
        return credencialIntIdCredencial;
    }

    public void setCredencialIntIdCredencial(int credencialIntIdCredencial) {
        this.credencialIntIdCredencial = credencialIntIdCredencial;
    }

    public int getRolIntIdRol() {
        return rolIntIdRol;
    }

    public void setRolIntIdRol(int rolIntIdRol) {
        this.rolIntIdRol = rolIntIdRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioPK usuarioPK = (UsuarioPK) o;

        if (intIdUsuario != usuarioPK.intIdUsuario) return false;
        if (credencialIntIdCredencial != usuarioPK.credencialIntIdCredencial) return false;
        if (rolIntIdRol != usuarioPK.rolIntIdRol) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = intIdUsuario;
        result = 31 * result + credencialIntIdCredencial;
        result = 31 * result + rolIntIdRol;
        return result;
    }
}
