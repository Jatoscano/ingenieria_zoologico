package com.example.demo.zoo.service;

import java.util.List;

import com.example.demo.zoo.repository.model.Veterinario;

public interface IVeterinarioService {
	
	public void registrar (Veterinario veterinario);
	
	public Veterinario buscarPorId(Integer id);
	
	public void actualizar(Veterinario veterinario);
	
	public List<Veterinario> buscarTodos();
	
	public Veterinario buscarPorCedula(String cedula);
	
	public void eliminar(Integer id);
	
}
