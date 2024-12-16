package com.rigistro.gado.demo.services.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rigistro.gado.demo.DTO.CreateAnimalDTO;
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
    return animalRepository.findAll();
  }

  @Override
  public Animal createAnimal(CreateAnimalDTO createAnimalDTO) {

    if (animalRepository.existsByName(createAnimalDTO.name())) {
      throw new IllegalArgumentException("An animal with this name already exists.");
    }

    Animal animal = new Animal();
    animal.setName(createAnimalDTO.name());
    animal.setNumeration(createAnimalDTO.numeration());
    animal.setAge(createAnimalDTO.age());
    animal.setSerie(createAnimalDTO.serie());
    animal.setBreed(createAnimalDTO.breed());
    animal.setPurity(createAnimalDTO.purity());
    animal.setRGD(createAnimalDTO.RGD());
    animal.setSex(createAnimalDTO.sex());
    animal.setBirthDate(createAnimalDTO.birthDate());
    animal.setLastBreeding(createAnimalDTO.lastBreeding());
    animal.setRegisteredWithGovernment(createAnimalDTO.registeredWithGovernment());
    animal.setReceiveNotifications(createAnimalDTO.receiveNotifications());
    animal.setImageUrl(createAnimalDTO.imageUrl());

    return animalRepository.save(animal);
  }
}
