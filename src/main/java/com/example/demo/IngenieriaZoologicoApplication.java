package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.zoo.repository.model.Animal;
import com.example.demo.zoo.repository.model.Proveedor;
import com.example.demo.zoo.service.IProveedorService;

@SpringBootApplication
public class IngenieriaZoologicoApplication implements CommandLineRunner{

	@Autowired
	IProveedorService iProveedorService;
	
	public static void main(String[] args) {
		SpringApplication.run(IngenieriaZoologicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//
		System.err.println(":)");
		/*List<Proveedor>  l=iProveedorService.buscarTodosProveedores();
		
		for (Proveedor proveedor : l) {
			System.out.println(proveedor);
		}*/
		
		
		
		
		
	}

}
