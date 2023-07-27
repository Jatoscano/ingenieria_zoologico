package com.example.demo.zoo.repository.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "articulo")
@Entity
public class Articulo {

	@Id
	@SequenceGenerator(allocationSize = 1,name = "seq_articulo",sequenceName = "seq_articulo")
	@GeneratedValue(generator = "seq_articulo", strategy = GenerationType.SEQUENCE)
	@Column(name = "arti_id")
	private Integer id;
	
	@Column(name = "arti_nombre")
	private String nombre;
	
	@Column(name = "arti_costo")
	private BigDecimal costo;
	
	@Column(name = "arti_stock")
	private Integer stock;
	
	//Relacion Articulo - Detalle
	@OneToMany(mappedBy = "articulo")
	private List<Detalle> detalles;
	
	//Relacion Tienda - Atriculo
	@ManyToMany
	@JoinTable(name = "articulo_tienda", 
    joinColumns = @JoinColumn(name = "arti_id_tienda"), 
    inverseJoinColumns = @JoinColumn(name  = "arti_id_articulo"))
	private Set<Tienda> tiendas;

	
	//To String
	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", costo=" + costo + ", stock=" + stock + ", detalles="
				+ detalles + ", tiendas=" + tiendas + "]";
	}

	//Get and Set
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

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Set<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(Set<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
}
