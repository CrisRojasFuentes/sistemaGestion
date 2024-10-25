package com.emprendamos.sistema_gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emprendamos.sistema_gestion.model.Producto;
import com.emprendamos.sistema_gestion.service.InventarioService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/inventario")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @PutMapping("/actualizar-stock/{id}")
    public ResponseEntity<Void> actualizarStock(@PathVariable Long id, @RequestParam int cantidad) {
    	System.out.println("p:" + id + "can" + cantidad);
        inventarioService.actualizarStock(id, cantidad);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/bajo-stock")
    public List<Producto> productosConBajoStock(@RequestParam(defaultValue = "10") int umbral) {
        return inventarioService.productosConBajoStock(umbral);
    }
}