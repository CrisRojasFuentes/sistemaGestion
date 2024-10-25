package com.emprendamos.sistema_gestion.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emprendamos.sistema_gestion.model.TransaccionFinanciera;
import com.emprendamos.sistema_gestion.service.FinanzasService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/finanzas")
public class FinanzasController {
    @Autowired
    private FinanzasService finanzasService;

    @PostMapping("/transaccion")
    public ResponseEntity<TransaccionFinanciera> registrarTransaccion(@RequestBody TransaccionFinanciera transaccion) {
        return ResponseEntity.ok(finanzasService.registrarTransaccion(transaccion));
    }

    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> obtenerBalance(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return ResponseEntity.ok(finanzasService.calcularBalancePeriodo(inicio, fin));
    }
}