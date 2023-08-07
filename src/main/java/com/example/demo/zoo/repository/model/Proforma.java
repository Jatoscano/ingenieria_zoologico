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
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Table(name = "proforma",schema = "public")
@Entity
public class Proforma {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_proforma")
	@SequenceGenerator(name = "seq_proforma", sequenceName = "seq_proforma", allocationSize = 1)
	@Column(name = "prof_id")
	private Integer id;
	@Column(name = "prof_costo_unidad")
	private BigDecimal costoUnidad;
	@Column(name = "prof_costo_total")
	private BigDecimal costoTotal;
	
	//RELACION CON ENTRADAS DE 1 A MUCHOS
	@OneToMany(mappedBy = "proforma", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	@OneToOne(mappedBy = "proforma", fetch = FetchType.LAZY)
	private Factura factura;

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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Proforma [id=" + id + ", costoUnidad=" + costoUnidad + ", costoTotal=" + costoTotal + ", productos="
				+ productos + ", factura=" + factura + "]";
	}

}
