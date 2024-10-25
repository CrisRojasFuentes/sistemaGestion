package com.emprendamos.sistema_gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emprendamos.sistema_gestion.model.Venta;
import com.emprendamos.sistema_gestion.service.VentaService;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable Long id) {
        return ventaService.getVentaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaService.saveVenta(venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        return ventaService.getVentaById(id)
                .map(ventaExistente -> {
                    venta.setIdVenta(id);
                    return ResponseEntity.ok(ventaService.saveVenta(venta));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/realizar")
    public ResponseEntity<Venta> realizarVenta(@RequestBody Venta venta) {
        return ResponseEntity.ok(ventaService.realizarVenta(venta));
    }

    @GetMapping("/por-fecha")
    public List<Venta> obtenerVentasPorFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ventaService.obtenerVentasPorFecha(fecha);
    }
}