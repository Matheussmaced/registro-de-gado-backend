package com.rigistro.gado.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rigistro.gado.demo.DTO.CreateAnimalDTO;
import com.rigistro.gado.demo.entity.Animal;

@Service
public interface AnimalService {

  List<Animal> findAll();

  Animal createAnimal(CreateAnimalDTO createAnimalDTO);
}
