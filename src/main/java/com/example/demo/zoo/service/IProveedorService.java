package com.example.demo.zoo.service;

import java.util.List;

import com.example.demo.zoo.repository.model.Proveedor;

public interface IProveedorService {
	
	
	public List<Proveedor> buscarTodosProveedores();
	public Proveedor buscar(Integer id);
	public void borrar (Integer id);
	public void actualizar(Proveedor proveedor);
	public void ingresar(Proveedor proveedor);

}
