package com.emprendamos.sistema_gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emprendamos.sistema_gestion.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	   List<Producto> findByStockLessThan(int umbral);

	   @Query("SELECT p FROM Producto p WHERE p.stock < :umbral")
    List<Producto> findProductosConBajoStock(@Param("umbral") int umbral);
}