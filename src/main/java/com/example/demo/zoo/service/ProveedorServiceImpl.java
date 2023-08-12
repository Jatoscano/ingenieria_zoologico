package com.example.demo.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IProveedorRepository;
import com.example.demo.zoo.repository.model.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	
	@Autowired
	private IProveedorRepository iProveedorRepository;
	
	@Override
	public List<Proveedor> buscarTodosProveedores() {
		// TODO Auto-generated method stub
		return iProveedorRepository.seleccionarProveedores();
	}

	@Override
	public Proveedor buscar(Integer id) {
		// TODO Auto-generated method stub
		return iProveedorRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		iProveedorRepository.eliminar(id);
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		iProveedorRepository.actualizar(proveedor);
	}

	@Override
	public void ingresar(Proveedor proveedor) {
		// TODO Auto-generated method stub
		iProveedorRepository.insertar(proveedor);
	}

}
