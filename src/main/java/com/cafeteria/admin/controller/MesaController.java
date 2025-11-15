package com.cafeteria.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafeteria.admin.model.Mesa;
import com.cafeteria.admin.service.MesaService;

@RestController
@RequestMapping("/api/mesa")
@CrossOrigin(origins = "*")
public class MesaController {

    private final MesaService service;

    public MesaController(MesaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mesa> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getById(@PathVariable Long id){
        return service.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mesa> create(@RequestBody Mesa mesa){
        Mesa nueva = service.save(mesa);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> update(@PathVariable Long id, @RequestBody Mesa mesa){
        return service.findById(id)
        .map(existing -> {
            mesa.setId(id);
            return ResponseEntity.ok(service.save(mesa));
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
