package com.example.demo.zoo.repository;

import com.example.demo.zoo.repository.model.Factura;

public interface IFacturaRepository {
	
	//CRUD
	public void inserta (Factura factura);
	public void actualizar (Factura factura);
	public Factura buscar (Integer id);
	public void eliminar (Integer id);
	
	
}
