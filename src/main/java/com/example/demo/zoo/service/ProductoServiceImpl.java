package com.example.demo.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IProductoRepository;
import com.example.demo.zoo.repository.model.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public void eliminarAgotados() {
		// TODO Auto-generated method stub
		iProductoRepository.eliminarAgotados();
	}

	@Override
	public List<Producto> buscar(String nombre) {
		// TODO Auto-generated method stub
		return iProductoRepository.buscar(nombre);
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return iProductoRepository.buscarTodos();
	}

	@Override
	public void actualizar(Producto alimentoDisponible) {
		// TODO Auto-generated method stub
		iProductoRepository.actualizar(alimentoDisponible);
	}

	@Override
	public void insertar(Producto alimentoDisponible) {
		// TODO Auto-generated method stub
		iProductoRepository.insertar(alimentoDisponible);
	}

	@Override
	public Producto buscarId(Integer id) {
		// TODO Auto-generated method stub
		return iProductoRepository.buscarId(id);
	}

	@Override
	public void eliminarId(Integer id) {
		// TODO Auto-generated method stub
		iProductoRepository.eliminarId(id);
	}

	
	

}
