package com.example.demo.zoo.service;

import java.util.List;

import com.example.demo.zoo.repository.model.Empleado;

public interface IEmpleadoService {
	
	public void agregar (Empleado empleado);
	
	public Empleado buscarPorId(Integer id);
	
	public void actualizar(Empleado empleado);
	
	public List<Empleado> buscarTodos();
	
	public Empleado buscarPorCedula(String cedula);
	
	public void eliminar(Integer id);

}