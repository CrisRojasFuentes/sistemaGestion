package com.emprendamos.sistema_gestion.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emprendamos.sistema_gestion.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFechaVenta(LocalDate fecha);
    List<Venta> findByFechaVentaBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<Venta> findByClienteId(Long clienteId);
}