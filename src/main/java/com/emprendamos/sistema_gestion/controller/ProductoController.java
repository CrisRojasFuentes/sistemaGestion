package com.emprendamos.sistema_gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emprendamos.sistema_gestion.model.Producto;
import com.emprendamos.sistema_gestion.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
    	List<Producto> p = new ArrayList<>();
    	List<Producto> lista = productoService.getAllProductos();
    	for(int i = 0; i < lista.size(); i++) {
    		if(lista.get(i).getEstado().equals(1)) {
    			p.add(lista.get(i));
    		}
    	}
    	
        return p;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
    	System.out.println(producto.toString());
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        return productoService.getProductoById(id)
                .map(productoExistente -> {
                    productoExistente.setNombre(productoActualizado.getNombre());
                    productoExistente.setDescripcion(productoActualizado.getDescripcion());
                    productoExistente.setPrecio(productoActualizado.getPrecio());
                    productoExistente.setStock(productoActualizado.getStock());
                    productoExistente.setEstado(productoActualizado.getEstado());
                    return ResponseEntity.ok(productoService.saveProducto(productoExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/elimina/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id) {
        return productoService.getProductoById(id)
                .map(producto -> {
                    producto.setEstado(0);
                    return ResponseEntity.ok(productoService.saveProducto(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }}
