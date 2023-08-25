package com.example.demo.zoo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IProductoRepository;
import com.example.demo.zoo.repository.model.Producto;
import com.example.demo.zoo.repository.model.accesos.ProductoPresupuesto;

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

	@Override
	public ProductoPresupuesto procesarPresupuesto(ProductoPresupuesto productoPresupuesto) {
		ProductoPresupuesto nuevoPP= new ProductoPresupuesto();
		nuevoPP=productoPresupuesto;
		BigDecimal subTotal=productoPresupuesto.getCostoUnitario().multiply(new BigDecimal(productoPresupuesto.getCantidad()));
		BigDecimal iva=subTotal.multiply(new BigDecimal(0.12f));
		BigDecimal total=subTotal.add(iva);

		nuevoPP.setSubTotal(subTotal);
		nuevoPP.setIva(iva);
		nuevoPP.setTotal(total);

		return nuevoPP;
	}
	
	
	

}
