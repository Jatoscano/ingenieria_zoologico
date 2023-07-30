package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Veterinario;

public interface IVeterinarioRepo {
	
	public void insertar(Veterinario veterinario);
	
	public Veterinario buscarPorId(Integer id);
	
	public void actualizar(Veterinario veterinario);
	
	public List<Veterinario> buscarTodos();
	
	public Veterinario buscarPorCedula(String cedula);
	
	public void eliminar(Integer id);

}
