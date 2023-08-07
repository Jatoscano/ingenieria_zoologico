package com.example.demo.zoo.repository.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "tienda")
@Entity
public class Tienda {

	@Id
	@SequenceGenerator(allocationSize = 1,name = "seq_tienda",sequenceName = "seq_tienda")
	@GeneratedValue(generator = "seq_tienda", strategy = GenerationType.SEQUENCE)
	@Column(name = "tien_id")
	private Integer id;
	
	@Column(name = "tien_horaEntrada")
	private LocalDateTime horaEntrada;
	
	@Column(name = "tien_horaSalida")
	private LocalDateTime horaSalida;
	
	//Relacion Tienda - Producto
	@OneToMany(mappedBy = "tienda")
	private List<Producto> productos;
	
	//Relacion Zoologico - Tienda
	@ManyToOne
	@JoinColumn(name = "tien_id_zoologico")
	private Zoologico zoologico;
	
	//Relacion Tienda - Cliente
	@OneToMany(mappedBy = "tienda")
	private List<Cliente> clientes;
	

	
	//To String
	
	@Override
	public String toString() {
		return "Tienda [id=" + id + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", productos="
				+ productos + ", zoologico=" + zoologico + ", clientes=" + clientes + "]";
	}
	
	//Get and Set

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}



	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}



	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}



	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public Zoologico getZoologico() {
		return zoologico;
	}



	public void setZoologico(Zoologico zoologico) {
		this.zoologico = zoologico;
	}



	public List<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
