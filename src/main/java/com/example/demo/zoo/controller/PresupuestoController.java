package com.example.demo.zoo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.zoo.repository.model.Producto;
import com.example.demo.zoo.repository.model.Proforma;
import com.example.demo.zoo.repository.model.accesos.Bandera;
import com.example.demo.zoo.repository.model.accesos.ProductoPresupuesto;
import com.example.demo.zoo.service.IProductoService;

@Controller
@RequestMapping("/presupuesto")
public class PresupuestoController {

	private List<ProductoPresupuesto> listaProductoPresupuestos;

	@Autowired
	private IProductoService iProductoService;

	@GetMapping("/iniciarPresupuesto")
	public String inicarPresupuesto(Producto producto,Bandera bandera, Model model) {
		listaProductoPresupuestos=new ArrayList<>();
		return "redirect:/presupuesto/listarPresupuesto";

	}

	@GetMapping("/listarPresupuesto")
	public String listarPresupuesto(Producto producto,Bandera bandera, Model model) {

		List<Producto> listaProductos=this.iProductoService.buscarTodos();
		model.addAttribute("modeloListaProductos",listaProductos);


		return "presupuesto/vistaProductosPresupuesto";

	}


	@GetMapping("/retornarPresupuesto")
	public String retornarPresupuesto(Producto producto,Bandera bandera, Model model) {
		Producto encontrado= this.iProductoService.buscarId(producto.getId());
		ProductoPresupuesto productoPresupuesto= new ProductoPresupuesto();
		productoPresupuesto.setCantidad(encontrado.getCantidad().floatValue());
		productoPresupuesto.setCostoUnitario(encontrado.getCosto());
		productoPresupuesto.setId(encontrado.getId());
		productoPresupuesto.setNombre(encontrado.getNombre());
		productoPresupuesto=this.iProductoService.procesarPresupuesto(productoPresupuesto);
		listaProductoPresupuestos.add(productoPresupuesto);

		System.out.println("PresupuestoController>>retornarPresupuesto>>listaProductoPresupuestos: "+listaProductoPresupuestos);
		System.out.println("PresupuestoController>>retornarPresupuesto>>bandera: "+bandera);
		if(bandera.isBandera()==false) {
			return "redirect:/presupuesto/listarPresupuesto";
		}else {
			//logica del presupeusto
			BigDecimal subtotal= new BigDecimal(0);
			BigDecimal iva= new BigDecimal(0);
			BigDecimal total= new BigDecimal(0);
			for (ProductoPresupuesto pp : listaProductoPresupuestos) {
				subtotal=subtotal.add(pp.getSubTotal());
				iva=iva.add(pp.getIva());
				total=total.add(pp.getTotal());
			}
			model.addAttribute("subtotalModel",subtotal);
			model.addAttribute("ivaModel",iva);
			model.addAttribute("totalModel",total);

			model.addAttribute("listaProductoPresupuestos",listaProductoPresupuestos);

			return "/presupuesto/vistaPresupuestoProductos";
		}

	}

	@GetMapping("/retornarMenu")
	public String crearPresupuesto(Producto producto,Bandera bandera, Model model) {

		return "redirect:/presupuesto/iniciarPresupuesto";
	}


}
