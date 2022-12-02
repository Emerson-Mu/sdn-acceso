package com.sdn.sdn_autenticador.service;

import com.sdn.sdn_autenticador.entity.Rol;
import com.sdn.sdn_autenticador.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RolService {

    private final RolRepository rolRepository;

    //Métodos disponibles

    public RolService(RolRepository rolRepository){
        this.rolRepository = rolRepository;
    }

    public List<Rol> listaRoles(){
        return rolRepository.findAll();
    }

    public Optional<Rol> buscarRolPorId(int id){
        return rolRepository.findById(id);
    }

}
