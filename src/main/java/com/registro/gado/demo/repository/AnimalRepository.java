package com.registro.gado.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.gado.demo.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
  boolean existsByName(String name);

  boolean existsByRDG(String RDG);

  boolean existsBySerie(String serie);

  Optional<Animal> findByName(String name);
}
