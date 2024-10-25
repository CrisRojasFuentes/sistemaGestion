package com.emprendamos.sistema_gestion.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emprendamos.sistema_gestion.model.TransaccionFinanciera;

@Repository
public interface TransaccionFinancieraRepository extends JpaRepository<TransaccionFinanciera, Long> {
    List<TransaccionFinanciera> findByFechaBetween(LocalDate inicio, LocalDate fin);
}