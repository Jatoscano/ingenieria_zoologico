package com.example.demo.zoo.service;

import java.util.List;

import com.example.demo.zoo.repository.model.Producto;
import com.example.demo.zoo.repository.model.Proveedor;
import com.example.demo.zoo.repository.model.accesos.ProductoPresupuesto;

public interface IProductoService {
	
	public void eliminarAgotados();
	public List<Producto> buscar(String nombre);
	public List<Producto> buscarTodos();
	public void actualizar(Producto alimentoDisponible);
	public void insertar (Producto alimentoDisponible);
	public Producto buscarId(Integer id);
	public void eliminarId(Integer id);
	public ProductoPresupuesto procesarPresupuesto(ProductoPresupuesto productoPresupuesto);

}
