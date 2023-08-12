package com.example.demo.zoo.service;

import java.util.List;

import com.example.demo.zoo.repository.model.Entrada;

public interface IEntradaService {

	public Entrada buscarPorId(Integer id);
	public Entrada buscarPorNumero(String numero);
	public List<Entrada> buscarTodos();
	public void agregar(Entrada entrada);
	public void actualizar(Entrada entrada);
	public void eliminarPorId(Integer id);
	
	
}
