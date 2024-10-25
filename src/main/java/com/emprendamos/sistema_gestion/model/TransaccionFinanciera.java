package com.emprendamos.sistema_gestion.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "transacciones_financieras")
public class TransaccionFinanciera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaccion")
	private Long id;
	private BigDecimal monto;
	private String tipo; // "INGRESO" o "GASTO"
	private LocalDate fecha;
	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TransaccionFinanciera [id=" + id + ", monto=" + monto + ", tipo=" + tipo + ", fecha=" + fecha
				+ ", descripcion=" + descripcion + "]";
	}

}
