package com.sdn.sdn_autenticador.service;

import com.sdn.sdn_autenticador.entity.Credencial;
import com.sdn.sdn_autenticador.repository.CredencialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CredencialService {
    private final CredencialRepository credencialRepository;
    public CredencialService(CredencialRepository credencialRepository){
        this.credencialRepository = credencialRepository;
    }

    public Credencial guardarCredencial(Credencial credencial){
        return credencialRepository.save(credencial);
    }

    public List<Credencial> listaCredenciales(){
        return credencialRepository.findAll();
    }

    public Optional<Credencial> buscarCredencialPorId(int id){
        return credencialRepository.findById(id);
    }
}
