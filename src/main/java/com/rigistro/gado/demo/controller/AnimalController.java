package com.rigistro.gado.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animal")
public class AnimalController {

  @RequestMapping("/{name}")
  public ResponseEntity<String> getAnimal(@PathVariable String name) {
    return ResponseEntity.ok("Nome do animal: " + name);
  }
}
