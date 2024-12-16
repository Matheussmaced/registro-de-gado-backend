package com.rigistro.gado.demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rigistro.gado.demo.entity.Animal;
import com.rigistro.gado.demo.repository.AnimalRepository;
import com.rigistro.gado.demo.services.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;

  public AnimalServiceImpl(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  public List<Animal> findAll() {
    List<Animal> animals = animalRepository.findAll();
    animalRepository.findAll();

    if (animals != null && animals.isEmpty()) {
      return animals;
    } else {
      return List.of();
    }
  }
}
