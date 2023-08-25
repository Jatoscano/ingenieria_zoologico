package com.example.demo.zoo.repository.model.accesos;

import java.math.BigDecimal;

public class ProductoPresupuesto {

	private Integer id;
	private String nombre;
	private BigDecimal costoUnitario;
	private Float cantidad;
	private BigDecimal subTotal;
	private BigDecimal iva;
	private BigDecimal total;
	
	
	public ProductoPresupuesto() {
		super();
	}
	
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
	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public Float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public BigDecimal getIva() {
		return iva;
	}
	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ProductoPresupuesto [id=" + id + ", nombre=" + nombre + ", costoUnitario=" + costoUnitario
				+ ", cantidad=" + cantidad + ", subTotal=" + subTotal + ", iva=" + iva + "]";
	}
	
	
	
	
}
