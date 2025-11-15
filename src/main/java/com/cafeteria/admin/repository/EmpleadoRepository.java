package com.cafeteria.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafeteria.admin.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
