package com.example.demo.zoo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.zoo.repository.model.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements  IProductoRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void eliminarAgotados() {
		// TODO Auto-generated method stub
		Query  query= this.entityManager.createQuery("Delete from Producto a Where a.cantidad = 0");
		query.executeUpdate();
	}

	@Override
	public List<Producto> buscar(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery< Producto> query=this.entityManager.createQuery("Select a from Producto where a.nombre = :nombre", Producto.class);
		query.setParameter("nombre", nombre);
		return query.getResultList();
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> query= this.entityManager.createQuery("SELECT a from Producto a", Producto.class);
		
		return query.getResultList();
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		entityManager.persist(producto);
	}

	@Override
	public Producto buscarId(Integer id) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Producto.class, id);
		
		
	}


	@Override
	public void eliminarId(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarId(id));
	}

}
