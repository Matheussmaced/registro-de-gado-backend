package com.rigistro.gado.demo.services.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rigistro.gado.demo.DTO.AnimalResponseDTO;
import com.rigistro.gado.demo.DTO.CreateAnimalDTO;
import com.rigistro.gado.demo.DTO.UpdateAnimalDTO;
import com.rigistro.gado.demo.entity.Animal;
import com.rigistro.gado.demo.repository.AnimalRepository;
import com.rigistro.gado.demo.services.AnimalService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;

  public AnimalServiceImpl(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  public List<AnimalResponseDTO> findAll() {
    return animalRepository.findAll().stream()
        .map(AnimalResponseDTO::new)
        .toList();
  }

  public Animal findById(String id) {
    var animalId = Long.parseLong(id);

    return animalRepository.findById(animalId)
        .orElseThrow(() -> new IllegalArgumentException("Animal not found with ID: " + id));
  }

  public Animal updateAnimal(String id, UpdateAnimalDTO updateAnimalDTO) {
    var animalId = Long.parseLong(id);
    Animal animalUpdate;

    animalUpdate = animalRepository.findById(animalId)
        .orElseThrow(() -> new EntityNotFoundException("Animal not found"));

    if (updateAnimalDTO.name() != null) {
      animalUpdate.setName(updateAnimalDTO.name());
    }
    if (updateAnimalDTO.numeration() != null) {
      animalUpdate.setNumeration(updateAnimalDTO.numeration());
    }
    if (updateAnimalDTO.age() > 0) {
      animalUpdate.setAge(updateAnimalDTO.age());
    }
    if (updateAnimalDTO.serie() != null) {
      animalUpdate.setSerie(updateAnimalDTO.serie());
    }
    if (updateAnimalDTO.breed() != null) {
      animalUpdate.setBreed(updateAnimalDTO.breed());
    }
    if (updateAnimalDTO.purity() != null) {
      animalUpdate.setPurity(updateAnimalDTO.purity());
    }
    if (updateAnimalDTO.RGD() != null) {
      animalUpdate.setRGD(updateAnimalDTO.RGD());
    }
    if (updateAnimalDTO.sex() != null) {
      animalUpdate.setSex(updateAnimalDTO.sex());
    }
    if (updateAnimalDTO.lastBreeding() != null) {
      animalUpdate.setLastBreeding(updateAnimalDTO.lastBreeding());
    }
    if (updateAnimalDTO.birthDate() != null) {
      animalUpdate.setBirthDate(updateAnimalDTO.birthDate());
    }

    animalUpdate.setRegisteredWithGovernment(updateAnimalDTO.registeredWithGovernment());
    animalUpdate.setReceiveNotifications(updateAnimalDTO.receiveNotifications());

    if (updateAnimalDTO.imageUrl() != null) {
      animalUpdate.setImageUrl(updateAnimalDTO.imageUrl());
    }
    if (updateAnimalDTO.motherName() != null) {
      Animal mother = animalRepository.findByName(updateAnimalDTO.motherName())
          .orElseThrow(
              () -> new EntityNotFoundException("Mother not found with name: " + updateAnimalDTO.motherName()));
      animalUpdate.setMother(mother);
    }
    if (updateAnimalDTO.fatherName() != null) {
      Animal father = animalRepository.findByName(updateAnimalDTO.fatherName())
          .orElseThrow(
              () -> new EntityNotFoundException("Father not found with name: " + updateAnimalDTO.fatherName()));
      animalUpdate.setFather(father);
    }

    return animalRepository.save(animalUpdate);
  }

  public void delete(String id) {
    var animalId = Long.parseLong(id);
    Animal animalToDelete;

    animalToDelete = animalRepository.findById(animalId)
        .orElseThrow(() -> new EntityNotFoundException("Animal not found"));

    if (animalToDelete.getOffspringAsFather() != null) {
      for (Animal offspring : animalToDelete.getOffspringAsFather()) {
        offspring.setFather(null);
      }
    }

    if (animalToDelete.getOffspringAsMother() != null) {
      for (Animal offspring : animalToDelete.getOffspringAsMother()) {
        offspring.setMother(null);
      }
    }

    animalRepository.saveAll(animalToDelete.getOffspringAsFather());
    animalRepository.saveAll(animalToDelete.getOffspringAsMother());

    animalRepository.delete(animalToDelete);

  }

  @Override
  public Animal createAnimal(CreateAnimalDTO createAnimalDTO) {

    if (animalRepository.existsByName(createAnimalDTO.name())) {
      throw new IllegalArgumentException("An animal with this name already exists.");
    }

    if (animalRepository.existsByName(createAnimalDTO.RGD())) {
      throw new IllegalArgumentException("An animal with this RGD already exists.");
    }

    if (animalRepository.existsByName(createAnimalDTO.serie())) {
      throw new IllegalArgumentException("An animal with this SERIE already exists.");
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

    // Associar mãe pelo nome, se fornecido
    if (createAnimalDTO.motherName() != null && !createAnimalDTO.motherName().isEmpty()) {
      Animal mother = animalRepository.findByName(createAnimalDTO.motherName())
          .orElseThrow(
              () -> new IllegalArgumentException("Mother not found with name: " + createAnimalDTO.motherName()));
      animal.setMother(mother);
    }

    // Associar pai pelo nome, se fornecido
    if (createAnimalDTO.fatherName() != null && !createAnimalDTO.fatherName().isEmpty()) {
      Animal father = animalRepository.findByName(createAnimalDTO.fatherName())
          .orElseThrow(
              () -> new IllegalArgumentException("Father not found with name: " + createAnimalDTO.fatherName()));
      animal.setFather(father);
    }

    return animalRepository.save(animal);
  }

}
