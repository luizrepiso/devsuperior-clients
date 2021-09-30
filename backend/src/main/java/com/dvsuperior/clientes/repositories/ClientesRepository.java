package com.dvsuperior.clientes.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dvsuperior.clientes.entities.Clientes;

@Repository
public interface ClientesRepository  extends JpaRepository<Clientes, Long> {

	
}
