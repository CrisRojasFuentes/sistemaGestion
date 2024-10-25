package com.emprendamos.sistema_gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprendamos.sistema_gestion.model.Producto;
import com.emprendamos.sistema_gestion.repository.ProductoRepository;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }
    
    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(id);
    }
    
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
}