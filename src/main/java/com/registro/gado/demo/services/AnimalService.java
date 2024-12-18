package com.registro.gado.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.registro.gado.demo.DTO.AnimalResponseDTO;
import com.registro.gado.demo.DTO.CreateAnimalDTO;
import com.registro.gado.demo.DTO.UpdateAnimalDTO;
import com.registro.gado.demo.entity.Animal;

@Service
public interface AnimalService {

  List<AnimalResponseDTO> findAll();

  Animal findById(String id);

  Animal createAnimal(CreateAnimalDTO createAnimalDTO);

  Animal updateAnimal(String id, UpdateAnimalDTO updateAnimalDTO);

  void delete(String id);
}
