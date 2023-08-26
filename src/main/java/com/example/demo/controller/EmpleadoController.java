package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Empleado;
import com.example.demo.service.IEmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/ingresarEmpleadoVst")
	public String ingresarEmpleadoVst(Empleado empleado) {
		
		return "vistaInsertarEmpleado";
	}
	
	
	@PostMapping("/ingresarEmpleado")
	public String ingresarEmpleado(Empleado empleado) {
		
		this.empleadoService.agregar(empleado);
		
		return "redirect:/empleado/ingresarEmpleadoVst";
	}
	
	@GetMapping("/buscarTodosEmpleadosVst")
	public String buscarTodosEmpleados(Model model) {
		
		List<Empleado> empleados = this.empleadoService.buscarTodos();
		System.err.println("entrar");
		for (Empleado empleado : empleados) {
			System.err.println("entrar2");

			System.out.println(empleado);
			
		}
		model.addAttribute("empleados", empleados);
		return "vistaListarEmpleados";
	}
	
	@DeleteMapping("/borrarEmpleado/{id}")
	public String borrarEmpleado(@PathVariable("id") Integer id) {
		this.empleadoService.eliminar(id);
		return"redirect:/empleado/buscarTodosEmpleadosVst";
	}
	
	
	@GetMapping("/buscarEmpleado/{id}")
	public String buscarEmpleado( @PathVariable("id") Integer id, Model model) {
		Empleado empleado= this.empleadoService.buscarPorId(id);
		model.addAttribute("empleado", empleado);
		return "vistaActualizarEmpleado";
	}
	
	@PostMapping("/actualizarEmpleado/{id}")
	public String actualizarEmpleado(Empleado empleado, @PathVariable ("id")Integer id){
		empleado.setId(id);
		this.empleadoService.actualizar(empleado);
		return"redirect:/empleado/buscarTodosEmpleadosVst";
	}
	
	
	
}
