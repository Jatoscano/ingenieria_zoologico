package com.example.demo.zoo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Tienda;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TiendaRepositoryImpl implements TiendaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Tienda tienda) {
		
		this.entityManager.persist(tienda);
	}

	@Override
	public void actualizar(Tienda tienda) {
		
		this.entityManager.merge(tienda);
	}

	@Override
	public Tienda seleccionar(Integer id) {
		
		return this.entityManager.find(Tienda.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

}
