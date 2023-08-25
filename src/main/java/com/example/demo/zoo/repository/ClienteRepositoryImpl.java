package com.example.demo.zoo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
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

	@Override
	public Cliente buscarPorCedula(String cedula) {
		TypedQuery<Cliente> query=this.entityManager.createQuery("select c from Cliente c where c.cedula=:datoCedula",Cliente.class);
		query.setParameter("datoCedula",cedula);
		
		Cliente cliente=null;
		
		try {
			cliente=query.getSingleResult();
		} catch (Exception e) {
		}
		
		return cliente;
	}
	
	

}
