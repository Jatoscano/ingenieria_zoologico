package com.example.demo.zoo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.zoo.repository.IAnimalRepository;
import com.example.demo.zoo.repository.model.Animal;

@Service
public class AnimalServiceImpl implements IAnimalService {

	@Autowired
	private IAnimalRepository animalRepository;
	
	@Override
	public void ingresar(Animal animal) {
		// TODO Auto-generated method stub
		animalRepository.insertar(animal);
	}

	@Override
	public void actualizar(Animal animal) {
		// TODO Auto-generated method stub
		animalRepository.actualizar(animal);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		animalRepository.borrar(id);
	}

	@Override
	public Animal encontrar(Integer id) {
		// TODO Auto-generated method stub
		return animalRepository.buscar(id);
	}

	@Override
	public List<Animal> encontrarTodos() {
		// TODO Auto-generated method stub
		return animalRepository.seleccionarTodos();
	}

}
