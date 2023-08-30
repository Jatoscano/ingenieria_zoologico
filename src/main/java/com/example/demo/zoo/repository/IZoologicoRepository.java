package com.example.demo.zoo.repository;


import com.example.demo.zoo.repository.model.Zoologico;

public interface IZoologicoRepository {
	
	public void insertar(Zoologico zoologico);
	public void actualizar(Zoologico zoologico);
	public Zoologico seleccionarUnico();
	

	
}
