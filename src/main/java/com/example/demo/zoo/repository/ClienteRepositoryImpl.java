package com.example.demo.zoo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteRepositoryImpl implements IClienteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void inserta(Cliente cliente) {
		this.entityManager.persist(cliente);
	
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
		
		
	}

	@Override
	public Cliente buscar(Integer id) {
		
		return 	this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(id);
		
	}

}
