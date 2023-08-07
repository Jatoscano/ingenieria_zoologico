package com.example.demo.zoo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Proveedor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;



@Repository
@Transactional
public class ProveedorRepositoryImpl implements IProveedorRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Proveedor> seleccionarProveedores() {
		// TODO Auto-generated method stub
		TypedQuery<Proveedor> query=this.entityManager.createQuery("Select p from Proveedor p",Proveedor.class);
		
		return query.getResultList();
	}

	@Override
	public Proveedor buscar(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Proveedor.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(proveedor);
	}

	@Override
	public void insertar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(proveedor);
	}

}
