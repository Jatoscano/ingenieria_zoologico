package com.example.demo.zoo.repository.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Table(name = "nota_venta",schema = "public")
@Entity
public class NotaVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_notaven")
	@SequenceGenerator(name = "seq_notaven", sequenceName = "seq_notaven", allocationSize = 1)
	@Column(name = "nove_id")
	private Integer id;
	@Column(name = "nove_costo_unidad")
	private BigDecimal costoUnidad;
	@Column(name = "nove_costo_total")
	private BigDecimal costoTotal;
	
	//RELACION CON ENTRADAS DE 1 A MUCHOS
	@OneToMany(mappedBy = "notaVenta", fetch = FetchType.LAZY)
	private List<Entrada> entradas;

	@OneToMany(mappedBy = "notaVenta", fetch = FetchType.LAZY)
	private List<Guia> guias;
	
	// set y get 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCostoUnidad() {
		return costoUnidad;
	}

	public void setCostoUnidad(BigDecimal costoUnidad) {
		this.costoUnidad = costoUnidad;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	@Override
	public String toString() {
		return "NotaVenta [id=" + id + ", costoUnidad=" + costoUnidad + ", costoTotal=" + costoTotal + ", entradas="
				+ entradas + "]";
	}

	
}
