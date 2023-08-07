package com.example.demo.zoo.repository.model;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Table(name = "zoologico")
@Entity
public class Zoologico {

	@Id
	@Column(name = "zool_id")
	private Integer id;
	@Column(name = "zool_ruc")
	private String ruc;
	@Column(name = "zool_nombre")
	private String nombre;
	@Column(name = "zool_direccion")
	private String direccion;
	@Column(name = "zool_tipo")
	private String tipo;

	@OneToMany(mappedBy = "zoologico")
	private List<Animal> animales;
	
	@OneToMany(mappedBy = "zoologico")
	private List<Entrada> entradas;
	
	@OneToMany(mappedBy = "zoologico")
	private List<Empleado> empleados;

	@OneToMany(mappedBy = "zoologico")
	private List<Tienda> tiendas;
	
	@OneToMany(mappedBy = "zoologico")
	private List<Cliente> clientes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Zoologico [id=" + id + ", ruc=" + ruc + ", nombre=" + nombre + ", direccion=" + direccion + ", tipo="
				+ tipo + ", animales=" + animales + ", entradas=" + entradas + ", empleados=" + empleados + ", tiendas="
				+ tiendas + ", clientes=" + clientes + "]";
	}

}
