package com.emprendamos.sistema_gestion.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprendamos.sistema_gestion.model.TransaccionFinanciera;
import com.emprendamos.sistema_gestion.repository.TransaccionFinancieraRepository;

@Service
public class FinanzasService {
    @Autowired
    
    private TransaccionFinancieraRepository transaccionRepository;

    public TransaccionFinanciera registrarTransaccion(TransaccionFinanciera transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public BigDecimal calcularBalancePeriodo(LocalDate inicio, LocalDate fin) {
        List<TransaccionFinanciera> transacciones = transaccionRepository.findByFechaBetween(inicio, fin);
        return transacciones.stream()
            .map(t -> t.getTipo().equals("INGRESO") ? t.getMonto() : t.getMonto().negate())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
