package com.example.demo.zoo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.ContratoGuia;

import aj.org.objectweb.asm.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ContratoGuiaRepoImpl implements IContratoGuiaRepo {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public ContratoGuia seleccionarPorId(Integer id) {
		return this.entityManager.find(ContratoGuia.class, id);
	}

	@Override
	public List<ContratoGuia> seleccionarPorCedula(String cedula) {
		TypedQuery<ContratoGuia> myQuery=this.entityManager.createQuery(""
				+ "select cg from Empleado e right join e.contratoGuias where e.cedula=:datoCedula",ContratoGuia.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getResultList();
	}

	@Override
	public void insertar(ContratoGuia contratoGuia) {
		this.entityManager.persist(contratoGuia);
	}

	@Override
	public void actualizar(ContratoGuia contratoGuia) {
		this.entityManager.merge(contratoGuia);

	}

	@Override
	public void eliminar(Integer id) {
		ContratoGuia contratoGuia=this.entityManager.find(ContratoGuia.class, id);
		this.entityManager.remove(contratoGuia);
	}

}
