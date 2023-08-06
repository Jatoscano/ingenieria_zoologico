package com.example.demo.zoo.service;

import com.example.demo.zoo.repository.model.Tienda;

public interface TiendaService {

	public void agregar(Tienda tienda);
	public void guardar(Tienda tienda);
	public Tienda buscar(Integer id);
	public void borrar(Integer id);
}
