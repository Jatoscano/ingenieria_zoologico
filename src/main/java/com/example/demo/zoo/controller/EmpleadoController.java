package com.example.demo.zoo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.zoo.repository.model.Animal;
import com.example.demo.zoo.repository.model.Producto;
import com.example.demo.zoo.repository.model.Proveedor;
import com.example.demo.zoo.service.IAnimalService;
import com.example.demo.zoo.service.IProductoService;
import com.example.demo.zoo.service.IProveedorService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	
	
	@Autowired
	private IAnimalService animalService;
	
	@Autowired
	private IProveedorService iProveedorService;
	
	
	@Autowired
	private IProductoService iProductoService;
	
	
	@GetMapping("/ingresarAnimalVst")
	public String ingresarAnimalVst(Animal animal) {
		
		return "vistaInsertarAnimal";
	}
	

	@PostMapping("/ingresarAnimal")
	public String ingresarAnimal(Animal animal) {
		
		this.animalService.ingresar(animal);
		
		return "redirect:/empleado/vistaListaAnimalesVst";
	}
	
	
	
	@GetMapping("/insertarProveedorVst")
 public String insertarProveedorVst(Proveedor proveedor) {
	 
	 return "vistaInsertarProveedor";
 }
 
	
	@PostMapping("/insertarProveedor")
	public String insertarProveedor(Proveedor proveedor) {
		
		this.iProveedorService.ingresar(proveedor);
		return"redirect:/empleado/buscarTodosProveedoresVst";
	}
	
	
	
	
	@GetMapping("/buscarTodosProveedoresVst")
	public String buscarTodosProveedores(Model model) {
		
		List<Proveedor> proveedores= this.iProveedorService.buscarTodosProveedores();
		model.addAttribute("proveedores", proveedores);
		return "vistaListarProveedores";
	}
	
	
	
	
	
	
	
	@DeleteMapping("/borrarProveedor/{id}")
	public String borrarProveedor(@PathVariable("id") Integer id) {
		this.iProveedorService.borrar(id);
		return"redirect:/empleado/buscarTodosProveedoresVst";
	}
	
	
	@GetMapping("/buscarProveedor/{id}")
	public String buscarProveedor( @PathVariable("id") Integer id, Model model) {
		Proveedor proveedor= this.iProveedorService.buscar(id);
		model.addAttribute("proveedor", proveedor);
		return "vistaActualizarProveedor";
	}
	
	@PostMapping("/actualizarProv/{id}")
	public String actualizarProv(Proveedor proveedor, @PathVariable ("id")Integer id){
		proveedor.setId(id);
		this.iProveedorService.actualizar(proveedor);
		return"redirect:/empleado/buscarTodosProveedoresVst";
	}
	
	
	
	@GetMapping("/vistaListaAnimalesVst")
	public String vistaListaAnimalesVst(Model model) {
		List<Animal> animales= this.animalService.encontrarTodos();
		model.addAttribute("animales", animales);
		
		return "vistaListaAnimales";
			
	}
	
	@DeleteMapping("/borrarAnimal/{id}")
	private String borrarAnimal(@PathVariable("id")Integer id) {
	
		this.animalService.borrar(id);
	
	return "redirect:/empleado/vistaListaAnimalesVst";
	}
	
	
	@GetMapping("/editarAnimalesVst/{id}")
	public String editarAnimalesVst(@PathVariable("id") Integer id, Model model){
		
		Animal animal= this.animalService.encontrar(id);
		model.addAttribute("animal", animal);
		return "vistaEditarAnimal";
	}
	
	
	@PutMapping("/actualizarAnimal/{id}")
	public String actualizarAnimal(Animal animal, @PathVariable("id") Integer id) {
		animal.setId(id);
		this.animalService.actualizar(animal);
		return "redirect:/empleado/vistaListaAnimalesVst";
	}
	
	
	///GESTION DE PRODUCTOS
	
	
	
	@GetMapping("/vistaListarProductosVst")
	public String vistaListarProductosVst(Model model) {
		iProductoService.eliminarAgotados();
		
		List<Producto> productos= this.iProductoService.buscarTodos();
		model.addAttribute("productos", productos);
		
		
		
		///ALERTA
		model.addAttribute("productos", productos);

	    boolean alertaCantidadUno = productos.stream().anyMatch(producto -> producto.getCantidad() == 1);
	    model.addAttribute("alertaCantidadUno", alertaCantidadUno);
		
		///
		
		
		
		
		return "vistaListarProductos";
	}
	
	
	@GetMapping("/vistaMensajeBorrarProductosVst")
	public String vistaMensajeBorrarProductosVst(Producto producto){
		
		return "vistaMensajeBorrarProductos";
	}
	
	
	@DeleteMapping("/borrarProducto/{id}")
	public String borrarProducto(@PathVariable("id") Integer id) {
		
		try {
			this.iProductoService.eliminarId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return "redirect:/empleado/vistaMensajeBorrarProductosVst";
		}
		
		
		return "redirect:/empleado/vistaListarProductosVst";
	}
	
	
	@GetMapping("/editarProductoVst/{id}")
	public String editarProductoVst( @PathVariable("id") Integer id, Model model) {
		
	Producto producto=	this.iProductoService.buscarId(id);
	model.addAttribute("producto", producto);
	
	
	List<Proveedor>	proveedores=this.iProveedorService.buscarTodosProveedores();

	model.addAttribute("proveedor", proveedores)	;

	
	
	
		return "vistaActualizarProducto";
	}
	
	@PutMapping("/guardarProductoActualizado/{id}")
	public String guardarProductoActualizado(@PathVariable("id") Integer id, @ModelAttribute("producto")Producto producto, @RequestParam("proveedorId") Integer proveedorId) {

		
		
		producto.setId(id);
		   // Obtener el producto existente desde la base de datos
	    Producto productoExistente = this.iProductoService.buscarId(id);

	    // Cargar el proveedor existente desde la base de datos usando su ID
	    Proveedor proveedorSeleccionado = this.iProveedorService.buscar(proveedorId);

	    // Verificar si el producto ya está relacionado con otro proveedor
	    for (Proveedor proveedorExistente : productoExistente.getProveedores()) {
	        if (!proveedorExistente.getId().equals(proveedorId)) {
	            // Eliminar el producto de la lista de productos del proveedor existente
	            proveedorExistente.getProductos().remove(productoExistente);
	        }
	    }

	    // Actualizar la lista de proveedores del producto
	    productoExistente.getProveedores().clear(); // Limpiamos la lista de proveedores
	    productoExistente.getProveedores().add(proveedorSeleccionado); // Agregamos el nuevo proveedor

	    // Verificar si el producto ya está relacionado con el proveedor seleccionado
	    if (!proveedorSeleccionado.getProductos().contains(productoExistente)) {
	        // Si no está relacionado, lo agregamos a la lista de productos del proveedor
	        proveedorSeleccionado.getProductos().add(productoExistente);
	    }

	    this.iProductoService.actualizar(producto);
	    
	    return "redirect:/empleado/vistaListarProductosVst";
	}
	
	
	
	
	@GetMapping("/insertarProductoVst")
	public String insertarProductoVst( Model model) {
		
	
	List<Proveedor>	proveedores=this.iProveedorService.buscarTodosProveedores();

	model.addAttribute("proveedor", proveedores)	;
	model.addAttribute("producto", new Producto())	;
	 
	return "vistaInsertarProducto";
		
	}

	
	
	@PostMapping("/guardarProducto")
	public String guardarProducto (@ModelAttribute("producto")Producto producto, @RequestParam("proveedorId") Integer proveedorId) {

		

		Proveedor proveedorSeleccionado= this.iProveedorService.buscar(proveedorId);
		System.out.println("p: "+proveedorSeleccionado );
		producto.getProveedores().add(proveedorSeleccionado);
		proveedorSeleccionado.getProductos().add(producto);
		
		
		this.iProductoService.insertar(producto);
		
		
		return "redirect:/empleado/vistaListarProductosVst";
	}

	
	
	
	
	
	

}
