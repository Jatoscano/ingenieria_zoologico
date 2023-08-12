package com.example.demo.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IClienteRepository;
import com.example.demo.zoo.repository.model.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteRepository clienteRepository;
	

	@Override
	public void crear(Cliente cliente) {
		this.clienteRepository.inserta(cliente);		
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.clienteRepository.actualizar(cliente);
		
	}

	@Override
	public Cliente buscar(Integer id) {
		
		return this.clienteRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.clienteRepository.eliminar(id);		
	}

}
