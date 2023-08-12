package com.example.demo.zoo.repository.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq_prov",sequenceName = "seq_prov")
	@GeneratedValue(generator = "seq_prov",strategy = GenerationType.SEQUENCE)
	@Column(name = "prov_id")
	private Integer id;
	
	@Column(name = "prov_nombre_completo")
	private String nombreCompleto;
	
	@Column(name = "prov_tiempo_entrega")
	private LocalDateTime tiempoEntrega;
	
	@Column(name = "prov_celular")
	private String celular;
	
	@Column(name = "prov_email")
	private String email;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "proveedor_prod", joinColumns = @JoinColumn(name="provprod_id_proveedor"), inverseJoinColumns = @JoinColumn(name="provprod_id_producto") )
	private List<Producto> productos;

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombreCompleto=" + nombreCompleto + ", tiempoEntrega=" + tiempoEntrega
				+ ", celular=" + celular + ", email=" + email + ", productos=" + productos + "]";
	}

	//GET&SET
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public LocalDateTime getTiempoEntrega() {
		return tiempoEntrega;
	}


	public void setTiempoEntrega(LocalDateTime tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
