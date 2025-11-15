package com.cafeteria.admin.dtos;

import java.math.BigDecimal;

import com.cafeteria.admin.model.Producto;

public record DetallePedidoDto(Integer cantidad, BigDecimal precioUnitario, Producto producto) {

}
