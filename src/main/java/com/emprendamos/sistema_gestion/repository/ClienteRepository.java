package com.emprendamos.sistema_gestion.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emprendamos.sistema_gestion.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}