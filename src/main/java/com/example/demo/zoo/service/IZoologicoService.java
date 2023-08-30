package com.example.demo.zoo.service;


import com.example.demo.zoo.repository.model.Zoologico;

public interface IZoologicoService {
	
	public void insertar(Zoologico zoologico);
	public void actualizar(Zoologico zoologico);
	public Zoologico buscarUnico();
	

	
}
