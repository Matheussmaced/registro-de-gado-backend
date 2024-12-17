package com.rigistro.gado.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rigistro.gado.demo.DTO.AnimalResponseDTO;
import com.rigistro.gado.demo.DTO.CreateAnimalDTO;
import com.rigistro.gado.demo.entity.Animal;

@Service
public interface AnimalService {

  List<AnimalResponseDTO> findAll();

  Animal findById(String id);

  Animal createAnimal(CreateAnimalDTO createAnimalDTO);

  void delete(String id);
}
