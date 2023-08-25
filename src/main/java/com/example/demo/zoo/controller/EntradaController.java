package com.example.demo.zoo.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.zoo.repository.model.Cliente;
import com.example.demo.zoo.repository.model.Entrada;
import com.example.demo.zoo.repository.model.EntradaNAT;
import com.example.demo.zoo.service.IClienteService;
import com.example.demo.zoo.service.IEntradaService;

@Controller
@RequestMapping("/entradas")
public class EntradaController {

	public static Logger LOG = LoggerFactory.getLogger(EntradaController.class);

	@Autowired
	private IEntradaService iEntradaService;

	@Autowired
	private IClienteService iClienteService;

	@GetMapping("/nuevaEntrada")
	public String paginaNuevaEntrada(Cliente cliente) {

		return "entradas/vistaFormularioCliente";
	}

	@GetMapping("/buscarCliente")
	public String paginaFormularioCedula(Cliente cliente, EntradaNAT entradaNAT,Model model) {
		Cliente clienteEncontrado = this.iClienteService.buscarPorCedula(cliente.getCedula());

		if (clienteEncontrado == null) {
			model.addAttribute("datosCliente",cliente);
			return "entradas/vistaFormularioRegistroCliente";
		}

		
		cliente = clienteEncontrado;
		model.addAttribute("datosCliente",cliente);
		System.out.println("EntradaController>>paginaFormularioCedula>>cliente:" + cliente);
		return "entradas/vistaNuevaEntrada";

	}

	@PostMapping("/insertarCliente")
	public String paginaFormularioInsertarCliente(Cliente cliente, EntradaNAT entradaNAT) {
		System.out.println("EntradaController>>paginaFormularioInsertarCliente>>cliente:" + cliente);
		this.iClienteService.crear(cliente);
		System.out.println("EntradaController>>paginaFormularioInsertarCliente>>cliente:" + cliente);

		return "entradas/vistaNuevaEntrada";

	}

	@PostMapping("/insertar")
	public String insertarEntrada(Cliente cliente, EntradaNAT entradaNAT) {
		// this.iEntradaService.agregar(entrada1);
		LOG.info("Entrada: " + entradaNAT.getEntradaNinio());
		LOG.info("Cantidad: " + entradaNAT.getEntradaNinio().getCantidad());
		List<Entrada> entradas = this.iEntradaService.agregarEntradaNAT(entradaNAT,cliente.getCedula());
		entradas.stream().map(String::valueOf).forEach(LOG::info);

		return "redirect:/entradas/nuevaEntrada";
	}

}
