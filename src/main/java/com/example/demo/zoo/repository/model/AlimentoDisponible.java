package com.example.demo.zoo.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "alimento_disponible")
@Entity
public class AlimentoDisponible {
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq_aldi",sequenceName = "seq_aldi")
	@GeneratedValue(generator = "seq_aldi", strategy = GenerationType.SEQUENCE)
	@Column(name = "aldi_id")
	private Integer id;
	
	@Column(name = "aldi_nombre")
    private String nombre;
	
	@Column(name = "aldi_cantidad_disponible")
    private Integer cantidadDisponible;
	
	@Column(name = "aldi_fecha_caducidad")
    private LocalDateTime fechaCaducidad;
	
	@Column(name = "aldi_limite_almacenamiento")
    private Integer limiteAlmacenamiento;
	
	@Column(name = "aldi_costo_peso")
    private BigDecimal costoPeso;
	
	@Column(name = "aldi_tipo")
    private String tipo;
	
	
	@ManyToMany
	@JoinTable(name = "alim_animal", joinColumns = @JoinColumn(name="alim_id"), inverseJoinColumns = @JoinColumn(name="animal_id"))
	private Set<Animal> animales;
	
	@ManyToMany(mappedBy = "alimentos")
	private Set<Proveedor> proveedores;

	
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

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public LocalDateTime getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Integer getLimiteAlmacenamiento() {
		return limiteAlmacenamiento;
	}

	public void setLimiteAlmacenamiento(Integer limiteAlmacenamiento) {
		this.limiteAlmacenamiento = limiteAlmacenamiento;
	}

	public BigDecimal getCostoPeso() {
		return costoPeso;
	}

	public void setCostoPeso(BigDecimal costoPeso) {
		this.costoPeso = costoPeso;
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
	

	
	
	
	
}
