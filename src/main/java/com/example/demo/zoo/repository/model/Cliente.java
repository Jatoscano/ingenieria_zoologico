package com.example.demo.zoo.repository.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Table(name = "cliente", schema = "public")
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
	@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
	@Column(name = "clie_id")
	private Integer id;
	@Column(name = "clie_nombre")
	private String nombre;
	@Column(name = "clie_apellido")
	private String apellido;
	@Column(name = "clie_cedula")
	private String cedula;
	@Column(name = "clie_direccion")
	private String direccion;
	@Column(name = "clie_email")
	private String email;


	// RELACION CON ENTRADAS DE 1 A MUCHOS

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Factura> facturas;	
	
	@ManyToOne()
	@JoinColumn(name = "clie_id_zoologico")
	private Zoologico zoologico;
	
	@ManyToOne()
	@JoinColumn(name = "clie_id_tienda")
	private Tienda tienda;

	@OneToOne(mappedBy = "cliente")
	private Entrada entrada;

	// set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Zoologico getZoologico() {
		return zoologico;
	}

	public void setZoologico(Zoologico zoologico) {
		this.zoologico = zoologico;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", direccion=" + direccion + ", email=" + email + ", facturas=" + facturas + ", zoologico="
				+ zoologico + ", tienda=" + tienda + ", entrada=" + entrada + "]";
	}

}
