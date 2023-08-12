package com.example.demo.zoo.repository.model;

import java.time.LocalDateTime;

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
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(generator = "seq_empleado" , strategy =  GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_empleado" ,sequenceName = "seq_empleado",allocationSize = 1)
	@Column(name = "empl_id")
	private Integer id;
	
	@Column(name = "empl_cedula_pasaporte")
	private String cedula_pasaporte;
	
	@Column(name = "empl_nombre")
	private String nombre;
	
	@Column(name = "empl_apellido")
	private String apellido;
	
	@Column(name = "empl_fecha_nacimiento")
	private String fechaNacimiento;
	
	@Column(name = "empl_fecha_contrato")
	private LocalDateTime fechaContrato;
	
	@Column(name = "empl_renovacion")
	private LocalDateTime fechaRenovacion;
	
	@Column(name = "empl_tipo")
	private String tipo;
	
	@Column(name = "empl_observacion")
	private String observacion;
		
	@ManyToOne
	@JoinColumn(name = "empl_id_zoologico")
	private Zoologico zoologico;

	//To String
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", cedula_pasaporte=" + cedula_pasaporte + ", nombre=" + nombre + ", apellido="
				+ apellido + ", fechaNacimiento=" + fechaNacimiento + ", fechaContrato=" + fechaContrato
				+ ", fechaRenovacion=" + fechaRenovacion + ", tipo=" + tipo + ", observacion=" + observacion
				+ ", zoologico=" + zoologico + "]";
	}

	//Get and Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula_pasaporte() {
		return cedula_pasaporte;
	}

	public void setCedula_pasaporte(String cedula_pasaporte) {
		this.cedula_pasaporte = cedula_pasaporte;
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDateTime getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(LocalDateTime fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public LocalDateTime getFechaRenovacion() {
		return fechaRenovacion;
	}

	public void setFechaRenovacion(LocalDateTime fechaRenovacion) {
		this.fechaRenovacion = fechaRenovacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Zoologico getZoologico() {
		return zoologico;
	}

	public void setZoologico(Zoologico zoologico) {
		this.zoologico = zoologico;
	}
	
}
