package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.AtencionMedica;
import com.example.demo.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AtencionMedicaRepoImpl implements IAtencionMedicaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(AtencionMedica atencionMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(atencionMedica);
	}

	@Override
	public AtencionMedica buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(AtencionMedica.class, id);
	}

	@Override
	public void actualizar(AtencionMedica atencionMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(atencionMedica);
	}

	@Override
	public List<AtencionMedica> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<AtencionMedica> query = this.entityManager.createQuery("select e from AtencionMedica e", AtencionMedica.class);
		 

		return  query.getResultList();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	AtencionMedica atencionMedica = this.buscarPorId(id);
	this.entityManager.remove(atencionMedica);
		
	}

}
