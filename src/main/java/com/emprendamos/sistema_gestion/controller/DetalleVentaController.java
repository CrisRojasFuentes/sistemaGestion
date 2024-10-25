package com.emprendamos.sistema_gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.emprendamos.sistema_gestion.model.DetalleVenta;
import com.emprendamos.sistema_gestion.service.ClienteService;
import com.emprendamos.sistema_gestion.service.DetalleVentaService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/detalle")
public class DetalleVentaController {

	@Autowired
	private DetalleVentaService detalleVentaService;
	
	@GetMapping
	public List<DetalleVenta> gerAll(){
		return detalleVentaService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalleVenta> gerById(@PathVariable Long id){
		return detalleVentaService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public DetalleVenta createDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
		return detalleVentaService.save(detalleVenta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DetalleVenta> updateDetalle(@PathVariable Long id, @RequestBody DetalleVenta body){
		return detalleVentaService.getById(id)
				.map(dt -> {
					dt.setProducto(body.getProducto());
					dt.setCantidad(body.getCantidad());
					dt.setTotalDetalle(body.getTotalDetalle());
					dt.setVenta(body.getVenta());
					return ResponseEntity.ok(detalleVentaService.save(dt));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDetalle(@PathVariable Long id){
		detalleVentaService.deleteDetalleVenta(id);
		return ResponseEntity.noContent().build();
	}
	
}
