package com.example.demo.zoo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Animal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AnimalRepositoryImpl implements IAnimalRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Animal animal) {
		// TODO Auto-generated method stub
		entityManager.persist(animal);
	}

	@Override
	public void actualizar(Animal animal) {
		// TODO Auto-generated method stub
		entityManager.merge(animal);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		entityManager.remove(this.buscar(id));
	}

	@Override
	public Animal buscar(Integer id) {
		// TODO Auto-generated method stub
		 return this.entityManager.find(Animal.class, id);
	}

	@Override
	public List<Animal> seleccionarTodos() {
		// TODO Auto-generated method stub
		
		
		TypedQuery<Animal> query= this.entityManager.createQuery("Select a from Animal a",Animal.class);
		
		return query.getResultList();
	}
	

}