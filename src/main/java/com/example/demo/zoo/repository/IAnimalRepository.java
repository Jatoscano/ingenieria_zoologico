package com.example.demo.zoo.repository;

import java.util.List;

import com.example.demo.zoo.repository.model.Animal;

public interface IAnimalRepository {
	
	
	
	public void insertar(Animal animal);
	public void actualizar(Animal animal);
	public void borrar(Integer id);
	public Animal buscar(Integer id);
	public List<Animal> seleccionarTodos();

}
