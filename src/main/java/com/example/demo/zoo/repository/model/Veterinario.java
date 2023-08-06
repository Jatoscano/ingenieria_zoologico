package com.example.demo.zoo.repository.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "veterinario")
@Entity
public class Veterinario {

	@GeneratedValue(generator = "seq_veterinario", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_veterinario", sequenceName = "seq_veterinario", allocationSize = 1)
	@Column(name = "vete_id")
	@Id
	private Integer id;

	@Column(name = "vete_nombre")
	private String nombre;

	@Column(name = "vete_apellido")
	private String apellido;

	@Column(name = "vete_cedula_pasaporte")
	private String cedula_pasaporte;

	@Column(name = "vete_fechaNacimiento")
	private LocalDateTime fechaNacimiento;

	@Column(name = "vete_direccion")
	private String direccion;

	@Column(name = "vete_especialidad")
	private String especialidad;

	@OneToMany(mappedBy = "veterinario")
	private List<AtencionMedica> atencionesMedicas;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula_pasaporte() {
		return cedula_pasaporte;
	}

	public void setCedula_pasaporte(String cedula_pasaporte) {
		this.cedula_pasaporte = cedula_pasaporte;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


}