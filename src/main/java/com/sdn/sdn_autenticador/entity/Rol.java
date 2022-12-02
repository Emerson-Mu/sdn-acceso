package com.sdn.sdn_autenticador.entity;

import jakarta.persistence.*;

@Entity
public class Rol {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "int_id_rol")
    private int intIdRol;
    @Basic
    @Column(name = "var_rol_nombre")
    private String varRolNombre;

    public int getIntIdRol() {
        return intIdRol;
    }

    public void setIntIdRol(int intIdRol) {
        this.intIdRol = intIdRol;
    }

    public String getVarRolNombre() {
        return varRolNombre;
    }

    public void setVarRolNombre(String varRolNombre) {
        this.varRolNombre = varRolNombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rol rol = (Rol) o;

        if (intIdRol != rol.intIdRol) return false;
        if (varRolNombre != null ? !varRolNombre.equals(rol.varRolNombre) : rol.varRolNombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = intIdRol;
        result = 31 * result + (varRolNombre != null ? varRolNombre.hashCode() : 0);
        return result;
    }
}
