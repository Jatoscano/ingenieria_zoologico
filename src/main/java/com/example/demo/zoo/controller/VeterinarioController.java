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

import com.example.demo.zoo.repository.model.Veterinario;
import com.example.demo.zoo.service.IVeterinarioService;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {

	@Autowired
	private IVeterinarioService veterinarioService;

	@GetMapping("/ingresarVeterinarioVst")
	public String ingresarVeterinarioVst(Veterinario veterinario) {

		return "vistaInsertarVeterinario";
	}


	@PostMapping("/ingresarVeterinario")
	public String ingresarVeterinario(Veterinario veterinario) {

		this.veterinarioService.registrar(veterinario);

		return "redirect:/veterinario/ingresarVeterinarioVst";
	}

	@GetMapping("/buscarTodosVeterinariosVst")
	public String buscarTodosVeterinarios(Model model) {

		List<Veterinario> veterinarios = this.veterinarioService.buscarTodos();

		model.addAttribute("veterinarios", veterinarios);
		return "vistaListarVeterinarios";
	}

	@DeleteMapping("/borrarVeterinario/{id}")
	public String borrarVeterinario(@PathVariable("id") Integer id) {
		this.veterinarioService.eliminar(id);
		return"redirect:/veterinario/buscarTodosVeterinariosVst";
	}


	@GetMapping("/buscarVeterinario/{id}")
	public String buscarVeterinario( @PathVariable("id") Integer id, Model model) {
        Veterinario veterinario= this.veterinarioService.buscarPorId(id);
		model.addAttribute("veterinario", veterinario);
		return "vistaActualizarVeterinario";
	}

	@PostMapping("/actualizarVeterinario/{id}")
	public String actualizarEmpleado(Veterinario veterinario , @PathVariable ("id")Integer id){
		veterinario.setId(id);
		this.veterinarioService.actualizar(veterinario);
		return"redirect:/veterinario/buscarTodosVeterinariosVst";
	}
}
