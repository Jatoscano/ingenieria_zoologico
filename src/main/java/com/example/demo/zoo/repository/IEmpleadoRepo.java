package com.example.demo.zoo.repository;

import java.util.List;

import com.example.demo.zoo.repository.model.Empleado;

public interface IEmpleadoRepo {

	public void insertar(Empleado empleado);
	
	public Empleado buscarPorId(Integer id);
	
	public void actualizar(Empleado empleado);
	
	public List<Empleado> buscarTodos();
	
	public Empleado buscarPorCedula(String cedula);
	
	public void eliminar(Integer id);
	
}
