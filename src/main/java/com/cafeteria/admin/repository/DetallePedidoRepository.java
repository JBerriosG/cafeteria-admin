package com.cafeteria.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cafeteria.admin.dtos.DetallePedidoDto;
import com.cafeteria.admin.model.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long>{

    @Query("SELECT new com.cafeteria.admin.dtos.DetallePedidoDto(d.cantidad, d.precioUnitario, d.producto) FROM DetallePedido d")
    List<DetallePedidoDto> findAllDetails();

}
