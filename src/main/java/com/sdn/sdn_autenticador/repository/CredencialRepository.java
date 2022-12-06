package com.sdn.sdn_autenticador.repository;

import com.sdn.sdn_autenticador.entity.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CredencialRepository extends JpaRepository<Credencial,Integer> {
    @Query(nativeQuery = true, value = "select categoria from (SELECT u.int_id_usuario as id, c.var_us_correo as usuario, c.var_us_password" +
            " as contrasenia, r.var_rol_nombre as categoria FROM usuario u inner join rol r on" +
            " (u.rol_int_id_rol = r.int_id_rol) inner join credencial c on (u.credencial_int_id_credencial = c.int_id_crd))" +
            " as subquery where subquery.usuario = ?1")
    List<String> obtenerRolesDelUsuario(String usuario);
}
