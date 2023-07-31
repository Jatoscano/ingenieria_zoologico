package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.modelo.Veterinario;
import com.example.demo.repository.IVeterinarioRepo;

public class VeterinarioServiceImpl implements IVeterinarioService{
	
	@Autowired
	private IVeterinarioRepo iVeterinarioRepo;
	

	@Override
	public void registrar(Veterinario veterinario) {
		// TODO Auto-generated method stub
		this.iVeterinarioRepo.insertar(veterinario);
	}

	@Override
	public Veterinario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iVeterinarioRepo.buscarPorId(id);
	}

	@Override
	public void actualizar(Veterinario veterinario) {
		// TODO Auto-generated method stub
		this.iVeterinarioRepo.actualizar(veterinario);
	}

	@Override
	public List<Veterinario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iVeterinarioRepo.buscarTodos();
	}

	@Override
	public Veterinario buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.buscarPorCedula(cedula);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iVeterinarioRepo.eliminar(id);
	}

	
	
}
