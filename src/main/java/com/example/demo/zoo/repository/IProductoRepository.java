package com.example.demo.zoo.repository;

import java.util.List;

import com.example.demo.zoo.repository.model.Producto;

public interface IProductoRepository {
	
	public void eliminarAgotados();
	public List<Producto> buscar(String nombre);
	public List<Producto> buscarTodos();
	public void actualizar(Producto alimentoDisponible);
	public void insertar (Producto alimentoDisponible);
	public Producto buscarId(Integer id);
	public void eliminarId(Integer id);

}
