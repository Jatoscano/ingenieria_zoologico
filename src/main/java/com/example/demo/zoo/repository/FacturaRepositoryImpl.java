package com.example.demo.zoo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void inserta(Factura factura) {
		this.entityManager.persist(factura);	
	}

	@Override
	public void actualizar(Factura factura) {
		this.entityManager.merge(factura);	
	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(id);
		
	}

}
