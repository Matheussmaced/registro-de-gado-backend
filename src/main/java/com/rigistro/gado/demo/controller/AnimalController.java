package com.rigistro.gado.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rigistro.gado.demo.DTO.CreateAnimalDTO;
import com.rigistro.gado.demo.entity.Animal;

import com.rigistro.gado.demo.services.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @GetMapping()
  public ResponseEntity<List<Animal>> findAll() {
    var animals = animalService.findAll();

    return ResponseEntity.ok(animals);

  }

  @PostMapping()
  public ResponseEntity<Animal> createAnimal(@RequestBody CreateAnimalDTO createAnimalDTO) {
    Animal savedAnimal = animalService.createAnimal(createAnimalDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAnimal);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }
}
