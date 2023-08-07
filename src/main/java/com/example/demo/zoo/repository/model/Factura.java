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

@Component
@Table(name = "factura",schema = "public")
@Entity
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_factura")
	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura", allocationSize = 1)
	@Column(name = "fact_id")
	private Integer id;
	@Column(name = "fact_subtotal")
	private BigDecimal subtotal;
	@Column(name = "fact_iva")
	private Double iva;
	@Column(name = "fact_total")
	private BigDecimal total;
	
	//RELACION CON ENTRADAS DE MUCHOS A 1 CON CLIENTE

	@OneToOne
	@JoinColumn(name = "fact_id_proforma")
	private Proforma proforma;
	
	@ManyToOne()
	@JoinColumn(name = "fact_id_cliente")
	private Cliente cliente;
	
	// GET Y SET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", cliente="
				+ cliente + "]";
	}
	
	
	

}
