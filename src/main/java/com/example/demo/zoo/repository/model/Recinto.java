package com.example.demo.zoo.repository.model;

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

@Table(name = "recinto")
@Entity
public class Recinto {
	
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq_rcin", sequenceName = "seq_rcin")
	@GeneratedValue(generator ="seq_rcin ", strategy = GenerationType.SEQUENCE)
	@Column(name="rcin_id")
	private Integer id;
	
	@Column(name="rcin_numero")
	private String numero;
	
	@Column(name="rcin_descripcion")
	private String descripcion;
	
	@Column(name="rcin_zona")
	private String zona;
	
	@ManyToMany()
	@JoinTable(name = "recinto_animal",joinColumns =  @JoinColumn(name = "recinto_id"), inverseJoinColumns = @JoinColumn(name="animal_id"))
	private Set<Animal> animales;

	
	//GET&SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Set<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(Set<Animal> animales) {
		this.animales = animales;
	}
	
	
	
	
	
	
	
	

}
