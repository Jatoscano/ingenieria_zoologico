package com.example.demo.zoo.repository;

import com.example.demo.zoo.repository.model.Tienda;

public interface TiendaRepository {

	public void insertar(Tienda tienda);
	public void actualizar(Tienda tienda);
	public Tienda seleccionar(Integer id);
	public void eliminar(Integer id);
}
