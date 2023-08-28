package com.example.demo.zoo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Proforma;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProformaRepositoryImpl implements IProformaRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void inserta(Proforma proforma) {
		this.entityManager.persist(proforma);
		
	}

	@Override
	public void actualizar(Proforma proforma) {
		this.entityManager.merge(proforma);
		
		
	}

	@Override
	public Proforma buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Proforma.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(id);;
		
	}

}
