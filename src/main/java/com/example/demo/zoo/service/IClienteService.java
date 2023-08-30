package com.example.demo.zoo.service;

import com.example.demo.zoo.repository.model.Cliente;

public interface IClienteService {
	
	//CRUD
	public void crear (Cliente cliente);
	public void actualizar (Cliente cliente);
	public Cliente buscar (Integer id);
	public void borrar (Integer id);
	public Cliente buscarPorCedula(String cedula);
}
