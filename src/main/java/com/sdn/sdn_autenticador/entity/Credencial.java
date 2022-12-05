package com.sdn.sdn_autenticador.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "credencial")
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

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario",
            joinColumns = @JoinColumn(name = "credencial_int_id_credencial"),
            inverseJoinColumns = @JoinColumn(name = "rol_int_id_rol")
    )
    private Set<Rol> roles = new HashSet<>();

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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
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
