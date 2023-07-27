package com.example.demo.zoo.repository.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Table(name = "guia")
@Entity
public class Guia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_guia")
	@SequenceGenerator(name = "seq_guia", sequenceName = "seq_guia", allocationSize = 1)
	@Column(name = "guia_id")
	private Integer id;
	@Column(name = "guia_fecha_hora_inicio")
	private LocalDateTime fechaHoraIncio;
	@Column(name = "guia_fecha_hora_fin")
	private LocalDateTime fechaHoraFin;
	@Column(name = "guia_costo")
	private BigDecimal costo;
	
	@ManyToOne
	@JoinColumn(name = "guia_id_empleado")
	private Empleado empleado;
	
	
	@ManyToOne
	@JoinColumn(name = "guia_id_nota_venta")
	private NotaVenta notaVenta;

	
	//gets  y sets
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaHoraIncio() {
		return fechaHoraIncio;
	}
	public void setFechaHoraIncio(LocalDateTime fechaHoraIncio) {
		this.fechaHoraIncio = fechaHoraIncio;
	}
	public LocalDateTime getFechaHoraFin() {
		return fechaHoraFin;
	}
	public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "Guia [id=" + id + ", fechaHoraIncio=" + fechaHoraIncio + ", fechaHoraFin=" + fechaHoraFin + ", costo="
				+ costo + "]";
	}
	
	
	
	
	
}
