package com.cafeteria.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cafeteria.admin.model.Mesa;

import com.cafeteria.admin.repository.MesaRepository;

@Service
public class MesaService {

    private final MesaRepository repository;

    public MesaService(MesaRepository repository) {
        this.repository = repository;
    }

    public List<Mesa> findAll(){
        return repository.findAll();
    }

    public Optional<Mesa> findById(Long id){
        return repository.findById(id);
    }

    public Mesa save(Mesa mesa){
        return repository.save(mesa);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
