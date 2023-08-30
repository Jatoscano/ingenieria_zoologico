package com.example.demo.zoo.repository;

import java.util.List;

import com.example.demo.zoo.repository.model.Proveedor;

public interface IProveedorRepository {

	
	public List<Proveedor> seleccionarProveedores();
	public Proveedor buscar(Integer id);
	public void eliminar (Integer id);
	public void actualizar(Proveedor proveedor);
	public void insertar(Proveedor proveedor);
	
	
}
