package com.dvsuperior.clientes.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.clientes.dto.ClientesDTO;
import com.dvsuperior.clientes.entities.Clientes;
import com.dvsuperior.clientes.repositories.ClientesRepository;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository repository;

	@Transactional(readOnly = true)
	public List<ClientesDTO> findAll() {
		List<Clientes> list = repository.findAll();
		return list.stream().map(x -> new ClientesDTO(x)).collect(Collectors.toList());

	}
}
