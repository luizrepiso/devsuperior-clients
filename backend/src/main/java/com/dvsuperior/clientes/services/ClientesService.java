package com.dvsuperior.clientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvsuperior.clientes.entities.Clientes;
import com.dvsuperior.clientes.repositories.ClientesRepository;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository repository;

	public List<Clientes> findAll() {
		return repository.findAll();

	}
}
