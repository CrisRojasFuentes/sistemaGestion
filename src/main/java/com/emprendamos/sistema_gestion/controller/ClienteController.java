package com.emprendamos.sistema_gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emprendamos.sistema_gestion.model.Cliente;
import com.emprendamos.sistema_gestion.service.ClienteService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
    	System.out.println("cliente: " + cliente.toString());
        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        return clienteService.getClienteById(id)
                .map(clienteExistente -> {
                    // Actualiza los campos individualmente
                    clienteExistente.setNombre(clienteActualizado.getNombre());
                    clienteExistente.setEmail(clienteActualizado.getEmail());
                    clienteExistente.setTelefono(clienteActualizado.getTelefono());
                    clienteExistente.setTipo(clienteActualizado.getTipo());
                    return ResponseEntity.ok(clienteService.saveCliente(clienteExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}