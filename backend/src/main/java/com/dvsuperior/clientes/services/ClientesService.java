package com.dvsuperior.clientes.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvsuperior.clientes.dto.ClientesDTO;
import com.dvsuperior.clientes.entities.Clientes;
import com.dvsuperior.clientes.repositories.ClientesRepository;
import com.dvsuperior.clientes.services.exceptions.DatabaseException;
import com.dvsuperior.clientes.services.exceptions.ResourceNotFoundException;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientesDTO> findAllPaged(PageRequest pageRequest) {
		Page<Clientes> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientesDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientesDTO findById(Long id) {
		Optional<Clientes> obj = repository.findById(id);
		Clientes entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientesDTO(entity);
	}

	@Transactional
	public ClientesDTO insert(ClientesDTO dto) {
		Clientes entity = new Clientes();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new ClientesDTO(entity);

	}

	@Transactional
	public ClientesDTO update(Long id, ClientesDTO dto) {
		try {
			Clientes entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new ClientesDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(" Id not found " + id);
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(" Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");

		}
	}
}
