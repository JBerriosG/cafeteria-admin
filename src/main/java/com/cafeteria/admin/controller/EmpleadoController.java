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

import com.cafeteria.admin.model.Empleado;
import com.cafeteria.admin.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Empleado> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable Long id){
        return service.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empleado> create(@RequestBody Empleado empleado){
        Empleado nueva = service.save(empleado);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> update(@PathVariable Long id, @RequestBody Empleado empleado){
        return service.findById(id)
        .map(existing -> {
            empleado.setId(id);
            return ResponseEntity.ok(service.save(empleado));
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
