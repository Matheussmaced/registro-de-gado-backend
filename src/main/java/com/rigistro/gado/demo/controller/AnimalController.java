package com.rigistro.gado.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rigistro.gado.demo.entity.Animal;
import com.rigistro.gado.demo.services.AnimalService;

@Controller
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
}
