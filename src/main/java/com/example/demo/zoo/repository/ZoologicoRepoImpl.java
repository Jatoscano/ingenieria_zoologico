package com.example.demo.zoo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Zoologico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ZoologicoRepoImpl implements IZoologicoRepo {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void actualizar(Zoologico zoologico) {
		this.entityManager.merge(zoologico);
	}

	@Override
	public Zoologico seleccionarPorId(String ruc) {
		TypedQuery<Zoologico> myQuery=this.entityManager.createQuery("select z from Zoologico z where z.ruc=:datoRuc",Zoologico.class);
		myQuery.setParameter("datoRuc", ruc);
		
		return myQuery.getSingleResult();
	}
	
	

}
