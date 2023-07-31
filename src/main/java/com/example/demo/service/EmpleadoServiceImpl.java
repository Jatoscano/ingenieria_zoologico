package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.Empleado;
import com.example.demo.repository.IEmpleadoRepo;

public class EmpleadoServiceImpl implements IEmpleadoService  {
	
	@Autowired
	private IEmpleadoRepo empleadoRepo;

	@Override
	public void agregar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.insertar(empleado);
		
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarPorId(id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.actualizar(empleado);
	}

	@Override
	public List<Empleado> buscarTodos() {
		// TODO Auto-generated method stub
		return this.empleadoRepo.buscarTodos();
	}

	@Override
	public Empleado buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.buscarPorCedula(cedula);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.empleadoRepo.eliminar(id);
	}

}
