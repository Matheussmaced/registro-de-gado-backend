package com.rigistro.gado.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rigistro.gado.demo.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
  boolean existsByName(String name);
}
