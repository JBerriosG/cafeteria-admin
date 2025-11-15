package com.cafeteria.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cafeteria.admin.model.Empleado;
import com.cafeteria.admin.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public List<Empleado> findAll(){
        return repository.findAll();
    }

    public Optional<Empleado> findById(Long id){
        return repository.findById(id);
    }

    public Empleado save(Empleado empleado){
        return repository.save(empleado);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
