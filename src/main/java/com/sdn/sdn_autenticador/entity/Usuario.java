package com.sdn.sdn_autenticador.entity;

import jakarta.persistence.*;

@Entity
@IdClass(UsuarioPK.class)
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "int_id_usuario")
    private int intIdUsuario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "credencial_int_id_credencial")
    private int credencialIntIdCredencial;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rol_int_id_rol")
    private int rolIntIdRol;
    @Basic
    @Column(name = "int_nivel")
    private int intNivel;

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

    public int getIntNivel() {
        return intNivel;
    }

    public void setIntNivel(int intNivel) {
        this.intNivel = intNivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (intIdUsuario != usuario.intIdUsuario) return false;
        if (credencialIntIdCredencial != usuario.credencialIntIdCredencial) return false;
        if (rolIntIdRol != usuario.rolIntIdRol) return false;
        if (intNivel != usuario.intNivel) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = intIdUsuario;
        result = 31 * result + credencialIntIdCredencial;
        result = 31 * result + rolIntIdRol;
        result = 31 * result + intNivel;
        return result;
    }
}
