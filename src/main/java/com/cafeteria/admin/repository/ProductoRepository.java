package com.cafeteria.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafeteria.admin.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
