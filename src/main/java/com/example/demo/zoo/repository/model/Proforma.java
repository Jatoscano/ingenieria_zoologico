package com.example.demo.zoo.repository.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Table(name = "proforma",schema = "public")
@Entity
public class Proforma {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_proforma")
	@SequenceGenerator(name = "seq_proforma", sequenceName = "seq_proforma", allocationSize = 1)
	@Column(name = "prof_id")
	private Integer id;
	@Column(name = "prof_subtotal")
	private BigDecimal subtotal;
	@Column(name = "prof_total")
	private BigDecimal total;
	
	//RELACION CON ENTRADAS DE 1 A MUCHOS
	
	//@OneToMany(mappedBy = "prof_producto", fetch = FetchType.LAZY)
	//private List<Producto> productos;
	
	//@OneToMany(mappedBy = "prof_factura", fetch = FetchType.LAZY)
	//private List<Factura> facturas;

	// set y get 
	
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
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Proforma [id=" + id + ", subtotal=" + subtotal + ", total=" + total + "]";
	}
	
	

}
