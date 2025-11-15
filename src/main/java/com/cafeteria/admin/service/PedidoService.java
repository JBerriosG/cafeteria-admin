package com.cafeteria.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cafeteria.admin.model.Pedido;
import com.cafeteria.admin.repository.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }
    
    public List<Pedido> findAll(){
        return repository.findAll();
    }

    public Optional<Pedido> findById(Long id){
        return repository.findById(id);
    }

    public Pedido save(Pedido pedido){
        return repository.save(pedido);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
