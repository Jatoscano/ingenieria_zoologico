package com.example.demo.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IFacturaRepository;
import com.example.demo.zoo.repository.model.Factura;

@Service
public class FacturaServiseImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Override
	public void ingresar(Factura factura) {
		this.facturaRepository.inserta(factura);
		
	}

	@Override
	public Factura buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.facturaRepository.eliminar(id);
		
	}

}
