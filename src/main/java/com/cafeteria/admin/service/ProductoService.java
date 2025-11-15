package com.cafeteria.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cafeteria.admin.model.Producto;
import com.cafeteria.admin.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
