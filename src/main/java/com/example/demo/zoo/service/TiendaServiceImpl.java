package com.example.demo.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.TiendaRepository;
import com.example.demo.zoo.repository.model.Tienda;

@Service
public class TiendaServiceImpl implements TiendaService{

	@Autowired
	private TiendaRepository tiendaRepository;
	@Override
	public void agregar(Tienda tienda) {
		
		this.tiendaRepository.insertar(tienda);
	}

	@Override
	public void guardar(Tienda tienda) {
		
		this.tiendaRepository.actualizar(tienda);
	}

	@Override
	public Tienda buscar(Integer id) {
		
		return this.tiendaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.tiendaRepository.eliminar(id);
	}

}
