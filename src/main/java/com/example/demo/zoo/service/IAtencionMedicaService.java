package com.example.demo.zoo.service;

import java.util.List;

import com.example.demo.zoo.repository.model.AtencionMedica;

public interface IAtencionMedicaService {
	
	public void agendar(AtencionMedica atencionMedica);
	
	public AtencionMedica buscarPorId(Integer id);
	
	public void reagendar(AtencionMedica atencionMedica);
	
	public List<AtencionMedica> buscarTodos();
	
	public void eliminar(Integer id);

}
