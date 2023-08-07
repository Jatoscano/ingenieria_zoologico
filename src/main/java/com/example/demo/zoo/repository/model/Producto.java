package com.example.demo.zoo.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "producto")
@Entity
public class Producto {
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", fechaCaducidad="
				+ fechaCaducidad + ", costo=" + costo + ", tipo=" + tipo + "]";
	}

	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq_prod",sequenceName = "seq_prod")
	@GeneratedValue(generator = "seq_prod", strategy = GenerationType.SEQUENCE)
	@Column(name = "prod_id")
	private Integer id;
	
	@Column(name = "prod_nombre")
    private String nombre;
	
	@Column(name = "prod_cantidad")
    private Integer cantidad;
	
	@Column(name = "prod_fecha_caducidad")
    private LocalDateTime fechaCaducidad;
	
	@Column(name = "prod_costo")
    private BigDecimal costo;
	
	@Column(name = "prod_tipo")
    private String tipo;
	
	
	@ManyToMany
	@JoinTable(name = "producto_animal", joinColumns = @JoinColumn(name="prodanim_id_prod"), inverseJoinColumns = @JoinColumn(name="prodanim_id_animal"))
	private Set<Animal> animales;
	
	@ManyToMany(mappedBy = "productos")
	private Set<Proveedor> proveedores;
	
	@ManyToOne
	@JoinColumn(name = "prod_id_proforma")
	private Proforma proforma;
	
	@ManyToOne
	@JoinColumn(name = "prod_id_tienda")
	private Tienda tienda;

	
	
	 public Producto() {
	        // Inicializar el conjunto de proveedores en el constructor
	        proveedores = new HashSet<>();
	    }

	//GET&SET

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



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public LocalDateTime getFechaCaducidad() {
		return fechaCaducidad;
	}



	public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}



	public BigDecimal getCosto() {
		return costo;
	}



	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public Set<Animal> getAnimales() {
		return animales;
	}



	public void setAnimales(Set<Animal> animales) {
		this.animales = animales;
	}



	public Set<Proveedor> getProveedores() {
		return proveedores;
	}



	public void setProveedores(Set<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}



	public Proforma getProforma() {
		return proforma;
	}



	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}



	public Tienda getTienda() {
		return tienda;
	}



	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
}
