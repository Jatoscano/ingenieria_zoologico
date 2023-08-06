package com.example.demo.zoo.repository;

import com.example.demo.zoo.repository.model.Proforma;

public interface IProformaRepository {
	
	//CRUD
	public void inserta (Proforma proforma);
	public void actualizar (Proforma proforma);
	public Proforma buscar (Integer id);
	public void eliminar (Integer id);
	
	
}
