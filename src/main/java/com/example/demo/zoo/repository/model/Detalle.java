package com.example.demo.zoo.repository.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "detalle")
@Entity
public class Detalle {

	@Id
	@SequenceGenerator(allocationSize = 1,name = "seq_detalle",sequenceName = "seq_detalle")
	@GeneratedValue(generator = "seq_detalle", strategy = GenerationType.SEQUENCE)
	@Column(name = "deta_id")
	private Integer id;
	
	@Column(name = "deta_cantidad")
	private Integer cantidad;
	
	@Column(name = "deta_costoUnidad")
	private BigDecimal costoUnidad;
	
	@Column(name = "deta_costo")
	private Integer costo;
		
	@ManyToOne
	@JoinColumn(name = "deta_id_articulo")
	private Articulo articulo;

	
	@ManyToOne
	@JoinColumn(name = "data_id_factura")
	private Factura factura;
	
	
	//To String
	@Override
	public String toString() {
		return "Detalle [id=" + id + ", cantidad=" + cantidad + ", costoUnidad=" + costoUnidad + ", costo=" + costo
				+ ", articulo=" + articulo + "]";
	}

	//Get and Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCostoUnidad() {
		return costoUnidad;
	}

	public void setCostoUnidad(BigDecimal costoUnidad) {
		this.costoUnidad = costoUnidad;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
}
