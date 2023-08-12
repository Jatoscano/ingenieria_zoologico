package com.example.demo.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IZoologicoRepository;
import com.example.demo.zoo.repository.model.Zoologico;

@Service
public class ZoologicoServiceImpl implements IZoologicoService {

	@Autowired
	private IZoologicoRepository iZoologicoRepository;

	@Override
	public void insertar(Zoologico zoologico) {
		this.iZoologicoRepository.insertar(zoologico);
	}

	@Override
	public void actualizar(Zoologico zoologico) {
		this.iZoologicoRepository.actualizar(zoologico);
	}

	@Override
	public Zoologico buscarUnico() {
		return this.iZoologicoRepository.seleccionarUnico();
	}

}
