package com.cafeteria.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafeteria.admin.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
