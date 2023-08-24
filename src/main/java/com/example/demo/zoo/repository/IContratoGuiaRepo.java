package com.example.demo.zoo.repository;

import java.util.List;

import com.example.demo.zoo.repository.model.ContratoGuia;

public interface IContratoGuiaRepo {

	public ContratoGuia seleccionarPorId(Integer id);
	public List<ContratoGuia> seleccionarPorCedula(String cedula);
	public void insertar(ContratoGuia contratoGuia);
	public void actualizar(ContratoGuia contratoGuia);
	public void eliminar(Integer id);
}
