package com.example.demo.zoo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.zoo.repository.model.Entrada;
import com.example.demo.zoo.repository.model.EntradaNAT;
import com.example.demo.zoo.service.IEntradaService;

@Controller
@RequestMapping("/entradas")
public class EntradaController {
	
	public static Logger LOG= LoggerFactory.getLogger(EntradaController.class);
	
	@Autowired
	private IEntradaService iEntradaService;
	
	@GetMapping("/nuevaEntrada")
	public String paginaNuevaEntrada(EntradaNAT entradaNAT) {
		
		
		return "vistaNuevaEntrada";
	}
	
	@PostMapping("/insertar")
	public String insertarEntrada(EntradaNAT entradaNAT) {
		//this.iEntradaService.agregar(entrada1);
		LOG.info("Entrada: "+entradaNAT.getEntradaNinio());
		LOG.info("Cantidad: "+entradaNAT.getEntradaNinio().getCantidad());
		List<Entrada> entradas=this.iEntradaService.agregarEntradaNAT(entradaNAT);
		entradas.stream().map(String::valueOf).forEach(LOG::info);
		
		
		return "redirect:/entradas/nuevaEntrada";
	}
	
}
