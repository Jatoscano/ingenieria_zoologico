package com.example.demo.zoo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Zoologico;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class IZoologicoRepositoryImpl implements IZoologicoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Zoologico zoologico) {
		this.entityManager.persist(zoologico);

	}

	@Override
	public void actualizar(Zoologico zoologico) {
		this.entityManager.merge(zoologico);

	}

	@Override
	public Zoologico seleccionarUnico() {
		TypedQuery<Zoologico> buscar=this.entityManager.createNamedQuery("select z from Zoologico z", Zoologico.class);
		
		return buscar.getSingleResult();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
