package com.sdn.sdn_autenticador.repository;

import com.sdn.sdn_autenticador.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
