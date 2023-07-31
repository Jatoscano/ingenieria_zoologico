package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Veterinario;

public interface IVeterinarioService {
	
	public void registrar (Veterinario veterinario);
	
	public Veterinario buscarPorId(Integer id);
	
	public void actualizar(Veterinario veterinario);
	
	public List<Veterinario> buscarTodos();
	
	public Veterinario buscarPorCedula(String cedula);
	
	public void eliminar(Integer id);
	
}
