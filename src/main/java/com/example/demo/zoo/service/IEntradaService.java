package com.example.demo.zoo.service;

import java.util.List;

import com.example.demo.zoo.repository.model.Entrada;
import com.example.demo.zoo.repository.model.EntradaNAT;

public interface IEntradaService {

	public Entrada buscarPorId(Integer id);
	public Entrada buscarPorNumero(String numero);
	public List<Entrada> buscarTodos();
	public void agregar(Entrada entrada);
	public List<Entrada> agregarEntradaNAT(EntradaNAT entradaNAT, String cedula);
	public void actualizar(Entrada entrada);
	public void eliminarPorId(Integer id);
	
	
	
	
	
}
