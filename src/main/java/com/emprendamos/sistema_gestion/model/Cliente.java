package com.emprendamos.sistema_gestion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	@Getter 
	@Setter
	private Integer id;

	@Column(name = "nombre", nullable = false)
	@Getter 
	@Setter
	private String nombre;

	@Column(name = "email")
	@Getter 
	@Setter
	private String email;

	@Column(name = "telefono")
	@Getter 
	@Setter
	private String telefono;
	
	@Column(name = "tipo")
	@Getter 
	@Setter
	private String tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", tipo="
				+ tipo + "]";
	}

	
	
	
}