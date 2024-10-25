package com.emprendamos.sistema_gestion.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "detalles_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    @Getter
    @Setter
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "id_ventas", nullable = false)
    @Column(name = "id_ventas")
    private Integer venta;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "total_detalle", nullable = false)
    private BigDecimal totalDetalle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVenta() {
		return venta;
	}

	public void setVenta(Integer venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getTotalDetalle() {
		return totalDetalle;
	}

	public void setTotalDetalle(BigDecimal totalDetalle) {
		this.totalDetalle = totalDetalle;
	}

	@Override
	public String toString() {
		return "DetalleVenta [id=" + id + ", venta=" + venta + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", totalDetalle=" + totalDetalle + "]";
	}


}
