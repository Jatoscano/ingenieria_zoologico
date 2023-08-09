package com.example.demo.zoo.repository.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Component
@Table(name = "entrada")
@Entity
public class Entrada {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entrada")
	@SequenceGenerator(name = "seq_entrada", sequenceName = "seq_entrada", allocationSize = 1)
	@Column(name = "entr_id")
	private Integer id;
	@Column(name = "entr_numero")
	private String numero;
	@Column(name = "entr_tipo")
	private String tipo;
	@Column(name = "entr_costo")
	private BigDecimal costo;

	@Transient
	private Integer cantidad;

	@ManyToOne
	@JoinColumn(name = "entr_id_zoologico")
	private Zoologico zoologico;

	@OneToOne
	@JoinColumn(name = "entr_id_cliente")
	private Cliente cliente;

	// Gets y sets

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Zoologico getZoologico() {
		return zoologico;
	}

	public void setZoologico(Zoologico zoologico) {
		this.zoologico = zoologico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", costo=" + costo + "]";
	}

}
