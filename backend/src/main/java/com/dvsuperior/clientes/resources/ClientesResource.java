package com.dvsuperior.clientes.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvsuperior.clientes.entities.Clientes;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesResource {
	
	@GetMapping
	public ResponseEntity<List<Clientes>> findAll(){
		List<Clientes> list = new ArrayList<>();
		list.add(new Clientes());
		return ResponseEntity.ok().body(list);
		
	}

}
