package com.emprendamos.sistema_gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emprendamos.sistema_gestion.model.DetalleVenta;
import com.emprendamos.sistema_gestion.repository.DetalleVentaRepository;

@Service
public class DetalleVentaService {

	@Autowired
	private DetalleVentaRepository repository;

	public List<DetalleVenta> getAll(){
		return repository.findAll();
	}
	
	public Optional<DetalleVenta> getById(Long id){
		return repository.findById(id);
	}
	
	public DetalleVenta save(DetalleVenta dv) {
		return repository.save(dv);
	}
	
	public void deleteDetalleVenta(Long id) {
		repository.deleteById(id);
	}
}
