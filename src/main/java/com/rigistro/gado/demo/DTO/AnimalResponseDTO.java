package com.rigistro.gado.demo.DTO;

import java.time.LocalDate;

import com.rigistro.gado.demo.entity.Animal;

public class AnimalResponseDTO {
  private Long id;
  private String name;
  private String numeration;
  private int age;
  private String serie;
  private String breed;
  private String purity;
  private String RGD;
  private String sex;
  private Long fatherId;
  private Long motherId;
  private LocalDate lastBreeding;
  private LocalDate birthDate;
  private boolean registeredWithGovernment;
  private boolean receiveNotifications;
  private String imageUrl;
  private String motherName;
  private String fatherName;

  public AnimalResponseDTO(Animal animal) {
    this.id = animal.getId();
    this.name = animal.getName();
    this.numeration = animal.getNumeration();
    this.age = animal.getAge();
    this.serie = animal.getSerie();
    this.breed = animal.getBreed();
    this.purity = animal.getPurity();
    this.RGD = animal.getRGD();
    this.sex = animal.getSex();
    this.lastBreeding = animal.getLastBreeding();
    this.birthDate = animal.getBirthDate();
    this.registeredWithGovernment = animal.isRegisteredWithGovernment();
    this.receiveNotifications = animal.isReceiveNotifications();
    this.imageUrl = animal.getImageUrl();

    // Informações dos pais, se existirem
    this.motherId = animal.getMother() != null ? animal.getMother().getId() : null;
    this.motherName = animal.getMother() != null ? animal.getMother().getName() : null;

    this.fatherId = animal.getFather() != null ? animal.getFather().getId() : null;
    this.fatherName = animal.getFather() != null ? animal.getFather().getName() : null;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNumeration() {
    return numeration;
  }

  public void setNumeration(String numeration) {
    this.numeration = numeration;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSerie() {
    return serie;
  }

  public void setSerie(String serie) {
    this.serie = serie;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public String getPurity() {
    return purity;
  }

  public void setPurity(String purity) {
    this.purity = purity;
  }

  public String getRGD() {
    return RGD;
  }

  public void setRGD(String rGD) {
    RGD = rGD;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Long getFatherId() {
    return fatherId;
  }

  public void setFatherId(Long fatherId) {
    this.fatherId = fatherId;
  }

  public Long getMotherId() {
    return motherId;
  }

  public void setMotherId(Long motherId) {
    this.motherId = motherId;
  }

  public LocalDate getLastBreeding() {
    return lastBreeding;
  }

  public void setLastBreeding(LocalDate lastBreeding) {
    this.lastBreeding = lastBreeding;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public boolean isRegisteredWithGovernment() {
    return registeredWithGovernment;
  }

  public void setRegisteredWithGovernment(boolean registeredWithGovernment) {
    this.registeredWithGovernment = registeredWithGovernment;
  }

  public boolean isReceiveNotifications() {
    return receiveNotifications;
  }

  public void setReceiveNotifications(boolean receiveNotifications) {
    this.receiveNotifications = receiveNotifications;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

}
