package com.sdn.sdn_autenticador.entity;

import jakarta.persistence.*;

@Entity
public class Credencial {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "int_id_crd")
    private int intIdCrd;
    @Basic
    @Column(name = "var_us_correo")
    private String varUsCorreo;
    @Basic
    @Column(name = "var_us_password")
    private String varUsPassword;

    public int getIntIdCrd() {
        return intIdCrd;
    }

    public void setIntIdCrd(int intIdCrd) {
        this.intIdCrd = intIdCrd;
    }

    public String getVarUsCorreo() {
        return varUsCorreo;
    }

    public void setVarUsCorreo(String varUsCorreo) {
        this.varUsCorreo = varUsCorreo;
    }

    public String getVarUsPassword() {
        return varUsPassword;
    }

    public void setVarUsPassword(String varUsPassword) {
        this.varUsPassword = varUsPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credencial that = (Credencial) o;

        if (intIdCrd != that.intIdCrd) return false;
        if (varUsCorreo != null ? !varUsCorreo.equals(that.varUsCorreo) : that.varUsCorreo != null) return false;
        if (varUsPassword != null ? !varUsPassword.equals(that.varUsPassword) : that.varUsPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = intIdCrd;
        result = 31 * result + (varUsCorreo != null ? varUsCorreo.hashCode() : 0);
        result = 31 * result + (varUsPassword != null ? varUsPassword.hashCode() : 0);
        return result;
    }
}
