package com.example.demo.zoo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

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

@Entity
@Table
public class Proveedor {
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq_prov",sequenceName = "seq_prov")
	@GeneratedValue(generator = "seq_prov",strategy = GenerationType.SEQUENCE)
	@Column(name = "prov_id")
	private Integer id;
	
	@Column(name = "prov_nombre_completo")
	private String nombreCompleto;
	
	@Column(name = "prov_tiempo_entrega")
	private LocalDateTime tiempoEntrega;
	
	@Column(name = "prov_celular")
	private String celular;
	
	@Column(name = "prov_email")
	private String email;
	
	
	@ManyToMany()
	@JoinTable(name = "proveedor_aldi", joinColumns = @JoinColumn(name="prov_id"), inverseJoinColumns = @JoinColumn(name="aldi_id") )
	private List<AlimentoDisponible> alimentos;


	
	//GET&SET
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public LocalDateTime getTiempoEntrega() {
		return tiempoEntrega;
	}


	public void setTiempoEntrega(LocalDateTime tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<AlimentoDisponible> getAlimentos() {
		return alimentos;
	}


	public void setAlimentos(List<AlimentoDisponible> alimentos) {
		this.alimentos = alimentos;
	}
	
	
	

}
