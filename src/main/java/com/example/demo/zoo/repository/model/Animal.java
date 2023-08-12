package com.example.demo.zoo.repository.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "animal")
@Entity
public class Animal {
	
	@Id
	@SequenceGenerator(allocationSize = 1,name = "seq_anim",sequenceName = "seq_anim")
	@GeneratedValue(generator = "seq_anim", strategy = GenerationType.SEQUENCE)
	@Column(name = "anim_id")
	private Integer id;

	@Column(name = "anim_mote")
	private String mote;
	
	@Column(name = "anim_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	
	@Column(name = "anim_edad")
	private Integer edad;
	
	@Column(name = "anim_tipo")
	private String tipo;
	
	@Column(name = "anim_especie")
	private String especie;
	
	@Column(name = "anim_nombre")
	private String nombre;
	
	@Column(name = "anim_observaciones")
	private String observaciones;
	
	@OneToMany(mappedBy = "animal")
	private List<AtencionMedica> atencionesMedicas;
	
	@ManyToOne
	@JoinColumn(name = "anim_id_zoologico")
	private Zoologico zoologico;
	
	@ManyToMany(mappedBy = "animales")
	private Set<Producto> productos;
	
	@Override
	public String toString() {
		return "Animal [id=" + id + ", mote=" + mote + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad
				+ ", tipo=" + tipo + ", especie=" + especie + ", nombre=" + nombre + ", observaciones=" + observaciones
				+ ", atencionesMedicas=" + atencionesMedicas + ", zoologico=" + zoologico + ", productos=" + productos
				+ "]";
	}
	
	//GET&SET
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<AtencionMedica> getAtencionesMedicas() {
		return atencionesMedicas;
	}

	public void setAtencionesMedicas(List<AtencionMedica> atencionesMedicas) {
		this.atencionesMedicas = atencionesMedicas;
	}

	public Zoologico getZoologico() {
		return zoologico;
	}

	public void setZoologico(Zoologico zoologico) {
		this.zoologico = zoologico;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
}
