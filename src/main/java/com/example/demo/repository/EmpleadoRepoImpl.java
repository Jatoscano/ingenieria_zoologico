package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class EmpleadoRepoImpl implements IEmpleadoRepo {
    
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		
		this.entityManager.persist(empleado);
		
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public List<Empleado> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> query = this.entityManager.createQuery("select e from Empleado e", Empleado.class);
		 

		return  query.getResultList();
	}

	@Override
	public Empleado buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, cedula);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Empleado empleado = this.buscarPorId(id);
		this.entityManager.remove(empleado);
		
	}

}
