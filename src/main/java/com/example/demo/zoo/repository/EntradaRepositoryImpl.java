package com.example.demo.zoo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Entrada;

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
public class EntradaRepositoryImpl implements IEntradaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Entrada seleccionarPorId(Integer id) {

		return this.entityManager.find(Entrada.class, id);
	}

	@Override
	public Entrada seleccionarPorNumero(String numero) {

		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Entrada> myQuery = myBuilder.createQuery(Entrada.class);
		Root<Entrada> tablaFrom = myQuery.from(Entrada.class);

		Predicate condicionNumero = myBuilder.equal(tablaFrom.get("numero"), numero);

		myQuery.select(tablaFrom).where(condicionNumero);

		TypedQuery<Entrada> myTypedQuery = this.entityManager.createQuery(myQuery);

		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Entrada> seleccionarTodos() {

		TypedQuery<Entrada> myQuery = this.entityManager.createQuery("select e from Entrada e",Entrada.class);

		return myQuery.getResultList();

	}

	@Override
	public void insertar(Entrada entrada) {
		this.entityManager.persist(entrada);
		
	}

	@Override
	public void actualizar(Entrada entrada) {
		this.entityManager.merge(entrada);
		

	}

	@Override
	public void eliminarPorId(Integer id) {
		Entrada entrada= this.entityManager.find(Entrada.class, id);
		this.entityManager.remove(entrada);

	}

}
