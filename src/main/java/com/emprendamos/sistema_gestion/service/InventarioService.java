package com.emprendamos.sistema_gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprendamos.sistema_gestion.model.Producto;
import com.emprendamos.sistema_gestion.repository.ProductoRepository;

@Service
public class InventarioService {
    @Autowired
    private ProductoRepository productoRepository;

    public void actualizarStock(Long productoId, int cantidad) {
        Producto producto = productoRepository.findById(productoId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setStock(producto.getStock() + cantidad);
        productoRepository.save(producto);
    }

    public List<Producto> productosConBajoStock(int umbral) {
        return productoRepository.findByStockLessThan(umbral);
    }
}
