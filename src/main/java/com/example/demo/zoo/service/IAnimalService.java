package com.example.demo.zoo.service;

import java.util.List;

import com.example.demo.zoo.repository.model.Animal;

public interface IAnimalService {
	
	public void ingresar(Animal animal);
	public void actualizar(Animal animal);
	public void borrar(Integer id);
	public Animal encontrar(Integer id);
	public List<Animal> encontrarTodos();

}
