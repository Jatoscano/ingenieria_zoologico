package com.example.demo.zoo.repository;

import java.util.List;

import com.example.demo.zoo.repository.model.Entrada;

public interface IEntradaRepository {

	public Entrada seleccionarPorId(Integer id);
	public Entrada seleccionarPorNumero(String numero);
	public List<Entrada> seleccionarTodos();
	public void insertar(Entrada entrada);
	public void actualizar(Entrada entrada);
	public void eliminarPorId(Integer id);
	
	
}
