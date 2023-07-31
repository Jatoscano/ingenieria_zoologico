package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.AtencionMedica;

public interface IAtencionMedicaService {
	
	public void agendar(AtencionMedica atencionMedica);
	
	public AtencionMedica buscarPorId(Integer id);
	
	public void reagendar(AtencionMedica atencionMedica);
	
	public List<AtencionMedica> buscarTodos();
	
	public void eliminar(Integer id);

}
