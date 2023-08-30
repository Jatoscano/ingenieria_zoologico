package com.example.demo.zoo.repository;

import com.example.demo.zoo.repository.model.Cliente;

public interface IClienteRepository {
	
	//CRUD
	public void inserta (Cliente cliente);
	public void actualizar (Cliente cliente);
	public Cliente buscar (Integer id);
	public void eliminar (Integer id);
	public Cliente buscarPorCedula(String cedula);
	
}
