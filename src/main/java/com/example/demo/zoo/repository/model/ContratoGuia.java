package com.example.demo.zoo.repository.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Table(name = "contrato_guia")
@Entity
public class ContratoGuia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contrato_guia")
	@SequenceGenerator(name = "seq_contrato_guia", sequenceName = "seq_contrato_guia", allocationSize = 1)
	@Column(name = "cgui_id")
	private Integer id;
	@Column(name = "cgui_fecha_hora_inicio")
	private LocalDateTime fechaHoraIncio;
	@Column(name = "cgui_fecha_hora_fin")
	private LocalDateTime fechaHoraFin;
	@Column(name = "cgui_costo")
	private BigDecimal costo;
	/*
	@ManyToOne
	@JoinColumn(name = "cgui_id_empleado")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name = "cgui_id_nota_venta")
	private NotaVenta notaVenta;
	
	*/
	
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
		return "CGuia [id=" + id + ", fechaHoraIncio=" + fechaHoraIncio + ", fechaHoraFin=" + fechaHoraFin + ", costo="
				+ costo + "]";
	}
	
	

}
