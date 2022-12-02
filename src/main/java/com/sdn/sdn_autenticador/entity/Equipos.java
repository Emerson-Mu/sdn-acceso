package com.sdn.sdn_autenticador.entity;

import jakarta.persistence.*;

@Entity
public class Equipos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "var_mac")
    private String varMac;
    @Basic
    @Column(name = "var_nombre")
    private String varNombre;
    @Basic
    @Column(name = "usuario_int_id_usuario")
    private int usuarioIntIdUsuario;

    public String getVarMac() {
        return varMac;
    }

    public void setVarMac(String varMac) {
        this.varMac = varMac;
    }

    public String getVarNombre() {
        return varNombre;
    }

    public void setVarNombre(String varNombre) {
        this.varNombre = varNombre;
    }

    public int getUsuarioIntIdUsuario() {
        return usuarioIntIdUsuario;
    }

    public void setUsuarioIntIdUsuario(int usuarioIntIdUsuario) {
        this.usuarioIntIdUsuario = usuarioIntIdUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipos equipos = (Equipos) o;

        if (usuarioIntIdUsuario != equipos.usuarioIntIdUsuario) return false;
        if (varMac != null ? !varMac.equals(equipos.varMac) : equipos.varMac != null) return false;
        if (varNombre != null ? !varNombre.equals(equipos.varNombre) : equipos.varNombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = varMac != null ? varMac.hashCode() : 0;
        result = 31 * result + (varNombre != null ? varNombre.hashCode() : 0);
        result = 31 * result + usuarioIntIdUsuario;
        return result;
    }
}
