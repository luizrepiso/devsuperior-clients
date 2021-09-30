package com.dvsuperior.clientes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.clientes.entities.Clientes;
import com.dvsuperior.clientes.services.ClientesService;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesResource {

	@Autowired
	private ClientesService service;

	@GetMapping
	public ResponseEntity<List<Clientes>> findAll() {
		List<Clientes> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

}
