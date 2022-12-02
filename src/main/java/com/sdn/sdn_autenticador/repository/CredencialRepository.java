package com.sdn.sdn_autenticador.repository;

import com.sdn.sdn_autenticador.entity.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepository extends JpaRepository<Credencial,Integer> {
}
