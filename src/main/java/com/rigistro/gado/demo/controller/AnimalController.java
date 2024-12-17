package com.rigistro.gado.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rigistro.gado.demo.DTO.AnimalResponseDTO;
import com.rigistro.gado.demo.DTO.CreateAnimalDTO;
import com.rigistro.gado.demo.entity.Animal;

import com.rigistro.gado.demo.services.AnimalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/animal")
@Tag(name = "Animal Controller", description = "Gerencia os registros de animais")
public class AnimalController {

  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @GetMapping()
  public ResponseEntity<List<AnimalResponseDTO>> findAll() {
    var animals = animalService.findAll();

    return ResponseEntity.ok(animals);

  }

  @GetMapping("/{id}")
  @Operation(summary = "Busca um animal por ID", description = "Retorna os detalhes do animal com o ID informado.")
  public ResponseEntity<AnimalResponseDTO> findById(@PathVariable String id) {
    Animal animal = animalService.findById(id);
    return ResponseEntity.ok(new AnimalResponseDTO(animal));
  }

  @PostMapping()
  @Operation(summary = "Cria um novo animal", description = "Adiciona um novo registro de animal ao banco de dados.")
  public ResponseEntity<Animal> createAnimal(@RequestBody CreateAnimalDTO createAnimalDTO) {
    Animal savedAnimal = animalService.createAnimal(createAnimalDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedAnimal);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Deleta um animal", description = "Deleta um animal no banco de dados.")
  public ResponseEntity<Void> deleteById(@PathVariable String id) {
    animalService.delete(id);

    return ResponseEntity.noContent().build();
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }
}
