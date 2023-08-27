package com.example.demo.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.zoo.repository.model.Cliente;
import com.example.demo.zoo.repository.model.Proveedor;
import com.example.demo.zoo.service.IClienteService;

@Controller
public class PrincipalController {
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping("/zoologico/inicio")
	public String inicio() {
		return "principal";
	}

	@RequestMapping("/zoologico/nosotros")
	public String nosotros() {
		return "nosotros";
	}
	
	@RequestMapping("/zoologico/fauna")
	public String fauna() {
		return "fauna";
	}
	
	@RequestMapping("/zoologico/tienda")
	public String compra() {
		return "compras";
	}
	
	@GetMapping("/zoologico/compras2")
	public String campras(Cliente cliente) {
		return "vistaDatosClienteC";
	}
	
	@PostMapping("/zoologico/insertarCliente")
	public String insertarCliente(Cliente cliente) {
		
		this.clienteService.crear(cliente);
		return"redirect:/vistaDatosClienteC";
	}
	
	@RequestMapping("/zoologico/administrativo")
	public String admi() {
		return "nosotros";
	}
	
	@RequestMapping("/zoologico/entradas")
	public String entrada() {
		return "entradas";
	}
	
	@RequestMapping("/zoologico/entradas2")
	public String entradas() {
		return "vistaDatosClienteE";
	}
	
}
