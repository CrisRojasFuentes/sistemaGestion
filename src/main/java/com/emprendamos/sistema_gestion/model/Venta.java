package com.emprendamos.sistema_gestion.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venta")
	private Long idVenta;

	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@Column(name = "fecha_venta", nullable = false)
	private LocalDate fechaVenta;

	@Column(name = "total", nullable = false)
	private BigDecimal total;

	//@OneToMany(mappedBy = "venta", orphanRemoval = true)
	//@Column(name = "")
	//private List<DetalleVenta> detalles ;



	public Cliente getCliente() {
		return cliente;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}



	
	
	
}