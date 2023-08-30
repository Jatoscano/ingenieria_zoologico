package com.example.demo.zoo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Veterinario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VeterinarioRepoImpl implements IVeterinarioRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Veterinario veterinario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(veterinario);
	}

	@Override
	public Veterinario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Veterinario.class, id);
	}

	@Override
	public void actualizar(Veterinario veterinario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(veterinario);
	}

	@Override
	public List<Veterinario> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Veterinario> query = this.entityManager.createQuery("select e from Veterinario e", Veterinario.class);

		return query.getResultList();
	}

	@Override
	public Veterinario buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Veterinario.class, cedula);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Veterinario veterinario = this.buscarPorId(id);
		this.entityManager.remove(veterinario);
		
	}

}
