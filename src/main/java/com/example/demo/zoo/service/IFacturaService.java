package com.example.demo.zoo.service;

import com.example.demo.zoo.repository.model.Factura;

public interface IFacturaService {
	
	//CRUD
	public void ingresar (Factura factura);
	public Factura buscar (Integer id);
	public void borrar (Integer id);
	
	
}
