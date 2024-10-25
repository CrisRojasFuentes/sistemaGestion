package com.emprendamos.sistema_gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprendamos.sistema_gestion.model.DetalleVenta;
import com.emprendamos.sistema_gestion.model.Producto;
import com.emprendamos.sistema_gestion.model.Venta;
import com.emprendamos.sistema_gestion.repository.ProductoRepository;
import com.emprendamos.sistema_gestion.repository.VentaRepository;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

	@Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private InventarioService inventarioService;

    @Transactional
    public Venta realizarVenta(Venta venta) {
//        for (DetalleVenta detalle : venta.getDetalles()) {
//            Producto producto = productoRepository.findById(detalle.getProducto().getId())
//                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
//            if (producto.getStock() < detalle.getCantidad()) {
//                throw new RuntimeException("Stock insuficiente");
//            }
//            inventarioService.actualizarStock(producto.getId(), -detalle.getCantidad());
//        }
//        return ventaRepository.save(venta);
    	return null;
    }

    public List<Venta> obtenerVentasPorFecha(LocalDate fecha) {
        return ventaRepository.findByFechaVenta(fecha);
    }

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> getVentaById(Long id) {
    	Optional<Venta> ventaCompleta = ventaRepository.findById(id);
    	Venta venta = new Venta();
    	
    	//venta.setDetalles(null);
        return ventaCompleta;
    }

    public Venta saveVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}