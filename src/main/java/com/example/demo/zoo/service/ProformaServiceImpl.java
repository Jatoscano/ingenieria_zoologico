package com.example.demo.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IProformaRepository;
import com.example.demo.zoo.repository.model.Proforma;

@Service
public class ProformaServiceImpl implements IProformaService{
	
	@Autowired
	private IProformaRepository proformaRepository;
	

	@Override
	public void ingresar(Proforma proforma) {
		this.proformaRepository.inserta(proforma);
	}

	@Override
	public void actualizar(Proforma proforma) {
		this.proformaRepository.actualizar(proforma);	
	}

	@Override
	public Proforma buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.proformaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.proformaRepository.eliminar(id);
		
	}

}
