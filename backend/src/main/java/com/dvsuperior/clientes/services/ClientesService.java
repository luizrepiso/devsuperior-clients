package com.dvsuperior.clientes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.clientes.dto.ClientesDTO;
import com.dvsuperior.clientes.entities.Clientes;
import com.dvsuperior.clientes.repositories.ClientesRepository;
import com.dvsuperior.clientes.services.exceptions.EntityNotFoundException;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository repository;

	@Transactional(readOnly = true)
	public List<ClientesDTO> findAll() {
		List<Clientes> list = repository.findAll();
		return list.stream().map(x -> new ClientesDTO(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public ClientesDTO findById(Long id) {
		Optional<Clientes> obj = repository.findById(id);
		Clientes entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new ClientesDTO(entity);
	}

	@Transactional
	public ClientesDTO insert(ClientesDTO dto) {
		Clientes entity = new Clientes();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new ClientesDTO(entity);

	}
}
