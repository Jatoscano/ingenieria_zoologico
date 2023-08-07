package com.example.demo.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IEntradaRepository;
import com.example.demo.zoo.repository.model.Entrada;

@Service
public class EntradaServiceImpl implements IEntradaService {

	@Autowired
	private IEntradaRepository iEntradaRepository;
	
	@Override
	public Entrada buscarPorId(Integer id) {
		return this.iEntradaRepository.seleccionarPorId(id);
	}

	@Override
	public Entrada buscarPorNumero(String numero) {
		return this.iEntradaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public List<Entrada> buscarTodos() {
		
		return this.iEntradaRepository.seleccionarTodos();
	}

	@Override
	public void agregar(Entrada entrada) {
		this.iEntradaRepository.insertar(entrada);
	}

	@Override
	public void actualizar(Entrada entrada) {
		this.iEntradaRepository.actualizar(entrada);
	}

	@Override
	public void eliminarPorId(Integer id) {

	}

}
