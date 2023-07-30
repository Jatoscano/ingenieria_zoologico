package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.AtencionMedica;

public interface IAtencionMedicaRepo {
	
	public void insertar(AtencionMedica atencionMedica);
	
	public AtencionMedica buscarPorId(Integer id);
	
	public void actualizar(AtencionMedica atencionMedica);
	
	public List<AtencionMedica> buscarTodos();
	
	public void eliminar(Integer id);

}
