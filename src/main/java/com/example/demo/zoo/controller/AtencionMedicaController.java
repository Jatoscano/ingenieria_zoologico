package com.example.demo.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.zoo.repository.model.AtencionMedica;
import com.example.demo.zoo.service.IAtencionMedicaService;

@Controller
@RequestMapping("/atencionMedica")
public class AtencionMedicaController {

	@Autowired
	private IAtencionMedicaService atencionMedicaService;

	@GetMapping("/ingresarAtencionMedicaVst")
	public String ingresarAtencionMedicaVst(AtencionMedica atencionMedica) {

		return "vistaInsertarAtencionMedica";
	}


	@PostMapping("/ingresarAtencionMedica")
	public String ingresarAtencionMedica(AtencionMedica atencionMedica) {

		this.atencionMedicaService.agendar(atencionMedica);

		return "redirect:/atencionMedica/ingresarAtencionMedicaVst";
	}

	@GetMapping("/buscarTodosAtencionMedicaVst")
	public String buscarTodosAtencionMedica(Model model) {

		List<AtencionMedica> atencionMedica = this.atencionMedicaService.buscarTodos();

		model.addAttribute("atencionMedica", atencionMedica);
		return "vistaListarAtencionMedica";
	}

	@DeleteMapping("/borrarAtencionMedica/{id}")
	public String borrarAtencionMedica(@PathVariable("id") Integer id) {
		this.atencionMedicaService.eliminar(id);
		return"redirect:/atencionMedica/buscarTodosAtencionMedicaVst";
	}


	@GetMapping("/buscarAtencionMedica/{id}")
	public String buscarAtencionMedica( @PathVariable("id") Integer id, Model model) {
		AtencionMedica atencionMedica= this.atencionMedicaService.buscarPorId(id);
		model.addAttribute("atencionMedica", atencionMedica);
		return "vistaActualizarAtencionMedica";
	}

	@PostMapping("/actualizarAtencionMedica/{id}")
	public String actualizarAtencionMedica(AtencionMedica atencionMedica , @PathVariable ("id")Integer id){
		atencionMedica.setId(id);
		this.atencionMedicaService.reagendar(atencionMedica);
		return"redirect:/atencionMedica/buscarTodosAtencionMedicaVst";
	}
}
