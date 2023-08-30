package com.example.demo.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IAtencionMedicaRepo;
import com.example.demo.zoo.repository.model.AtencionMedica;

@Service
public class AtencionMedicaServiceImpl implements IAtencionMedicaService {
	
	@Autowired
	private IAtencionMedicaRepo atencionMedicaRepo;
	

	@Override
	public void agendar(AtencionMedica atencionMedica) {
		// TODO Auto-generated method stub
		this.atencionMedicaRepo.insertar(atencionMedica);
	}

	@Override
	public AtencionMedica buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.atencionMedicaRepo.buscarPorId(id);
	}

	@Override
	public void reagendar(AtencionMedica atencionMedica) {
		// TODO Auto-generated method stub
		this.atencionMedicaRepo.actualizar(atencionMedica);
	}

	@Override
	public List<AtencionMedica> buscarTodos() {
		// TODO Auto-generated method stub
		return this.atencionMedicaRepo.buscarTodos();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
		this.atencionMedicaRepo.eliminar(id);
		
	}

}
