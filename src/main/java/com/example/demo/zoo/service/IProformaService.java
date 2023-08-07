package com.example.demo.zoo.service;

import com.example.demo.zoo.repository.model.Proforma;

public interface IProformaService {
	
	//CRUD
	public void ingresar (Proforma proforma);
	public void actualizar ( Proforma proforma);
	public Proforma buscar (Integer id);
	public void borrar (Integer id);
	
	
}
