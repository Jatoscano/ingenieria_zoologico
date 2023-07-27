package com.example.demo.zoo.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "atencion_medica")
public class AtencionMedica {

	//@GeneratedValue(generator = "seq_atencion_medica" , strategy =  GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "seq_atencion_medica" ,sequenceName = "seq_atencion_medica",allocationSize = 1)
	@Column(name = "atme_id")
	@Id
	private Integer id;
	
	
	@Column(name = "atme_peso")
	private Float peso;
	
	
	@Column(name = "atme_alergia")
	private String alergia;
	
	
	@Column(name = "atme_reflejo")
	private String reflejo;
	
	
	@Column(name = "atme_receta")
	private String receta;
	
	
	@Column(name = "atme_observacion")
	private String observacion;
	
	@ManyToOne
	@JoinColumn(name = "atencionMedica_id_veterinario")
	private Veterinario veterinario;
	
	@ManyToOne
	@JoinColumn(name = "atencionMedica_id_empleado")
	private Empleado empleado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getReflejo() {
		return reflejo;
	}

	public void setReflejo(String reflejo) {
		this.reflejo = reflejo;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
