package com.example.demo.zoo.repository;

import com.example.demo.zoo.repository.model.Zoologico;

public interface IZoologicoRepo {

	public void actualizar(Zoologico zoologico);
	public Zoologico seleccionarPorId(String ruc);
}
