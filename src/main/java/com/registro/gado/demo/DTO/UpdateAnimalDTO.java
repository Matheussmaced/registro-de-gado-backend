package com.registro.gado.demo.DTO;

import java.time.LocalDate;

public record UpdateAnimalDTO(
    String name,
    String numeration,
    int age,
    String serie,
    String breed,
    String purity,
    String RGD,
    String sex,
    LocalDate lastBreeding,
    LocalDate birthDate,
    boolean registeredWithGovernment,
    boolean receiveNotifications,
    String imageUrl,
    String motherName,
    String fatherName) {

}
