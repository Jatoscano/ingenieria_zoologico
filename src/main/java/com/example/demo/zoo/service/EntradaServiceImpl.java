package com.example.demo.zoo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IEntradaRepository;
import com.example.demo.zoo.repository.model.Cliente;
import com.example.demo.zoo.repository.model.Entrada;
import com.example.demo.zoo.repository.model.EntradaNAT;

@Service
public class EntradaServiceImpl implements IEntradaService {

	@Autowired
	private IEntradaRepository iEntradaRepository;
	
	@Autowired
	private IClienteService iClienteService;
	
	@Override
	public Entrada buscarPorId(Integer id) {
		return this.iEntradaRepository.seleccionarPorId(id);
	}

	@Override
	public Entrada buscarPorNumero(String numero) {
		return this.iEntradaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public List<Entrada> buscarTodos() {
		
		return this.iEntradaRepository.seleccionarTodos();
	}

	@Override
	public void agregar(Entrada entrada) {
		this.iEntradaRepository.insertar(entrada);
	}

	@Override
	public List<Entrada> agregarEntradaNAT(EntradaNAT entradaNAT, String cedula) {
		List<Entrada> entradasEntregar = new ArrayList<>();
		Entrada entradaSEC = entradaNAT.getEntradaNinio();

		Cliente cliente=this.iClienteService.buscarPorCedula(cedula);


		if (entradaSEC!=null && entradaSEC.getCantidad()!=null && entradaSEC.getCantidad() > 0) {
			// procedo con las inserciones
			for (int i = 0; i < entradaSEC.getCantidad(); i++) {
				Entrada pivote = new Entrada();
				pivote.setCliente(null);
				pivote.setNumero(String.valueOf((int) (Math.random() * 1000000000)));
				pivote.setCosto(new BigDecimal(2));
				pivote.setTipo("ninio");
				pivote.setZoologico(null);

				//Inicio parte de Clientes
				pivote.setCliente(cliente);
				List<Entrada> entradasSets= new ArrayList<>();
				entradasSets.add(pivote);
				cliente.setEntradas(entradasSets);
				//Fin parte de Clientes

				this.iEntradaRepository.insertar(pivote);
				entradasEntregar.add(pivote);

			}

		}

		entradaSEC = entradaNAT.getEntradaAdulto();

		if (entradaSEC!=null && entradaSEC.getCantidad()!=null && entradaSEC.getCantidad() > 0) {
			// procedo con las inserciones
			for (int i = 0; i < entradaSEC.getCantidad(); i++) {
				Entrada pivote = new Entrada();
				pivote.setCliente(null);
				pivote.setNumero(String.valueOf((int) (Math.random() * 1000000000)));
				pivote.setCosto(new BigDecimal(5));
				pivote.setTipo("adulto");
				pivote.setZoologico(null);

				//Inicio parte de Clientes
				pivote.setCliente(cliente);
				List<Entrada> entradasSets= new ArrayList<>();
				entradasSets.add(pivote);
				cliente.setEntradas(entradasSets);
				//Fin parte de Clientes

				this.iEntradaRepository.insertar(pivote);
				entradasEntregar.add(pivote);

			}

		}

		entradaSEC = entradaNAT.getEntradaTerceraEdad();

		if (entradaSEC!=null && entradaSEC.getCantidad()!=null && entradaSEC.getCantidad() > 0) {
			// procedo con las inserciones
			for (int i = 0; i < entradaSEC.getCantidad(); i++) {
				Entrada pivote = new Entrada();
				pivote.setCliente(null);
				pivote.setNumero(String.valueOf((int) (Math.random() * 1000000000)));
				pivote.setCosto(new BigDecimal(3));
				pivote.setTipo("tercera_edad");
				pivote.setZoologico(null);

				//Inicio parte de Clientes
				pivote.setCliente(cliente);
				List<Entrada> entradasSets= new ArrayList<>();
				entradasSets.add(pivote);
				cliente.setEntradas(entradasSets);
				//Fin parte de Clientes

				this.iEntradaRepository.insertar(pivote);
				entradasEntregar.add(pivote);

			}

		}

		return entradasEntregar;
	}
	
	@Override
	public void actualizar(Entrada entrada) {
		this.iEntradaRepository.actualizar(entrada);
	}

	@Override
	public void eliminarPorId(Integer id) {

	}
}
