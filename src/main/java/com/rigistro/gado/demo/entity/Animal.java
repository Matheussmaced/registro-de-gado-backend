package com.rigistro.gado.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "animals")
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String numeration;

  @Column(nullable = false)
  private int age;

  @Column(nullable = false)
  private String serie;

  @Column(nullable = false)
  private String breed;

  @Column(nullable = false)
  private String purity;

  @Column(nullable = false, unique = true)
  private String RGD;

  @Column(nullable = false)
  private String sex;

  @ManyToOne
  @JoinColumn(name = "id_father", referencedColumnName = "id")
  @JsonBackReference
  private Animal father;

  @ManyToOne
  @JoinColumn(name = "id_mother", referencedColumnName = "id")
  @JsonBackReference
  private Animal mother;

  @OneToMany(mappedBy = "father", cascade = CascadeType.ALL)
  @JsonBackReference
  private List<Animal> offspringAsFather;

  @OneToMany(mappedBy = "mother", cascade = CascadeType.ALL)
  @JsonBackReference
  private List<Animal> offspringAsMother;

  @Column(name = "last_breeding", nullable = true)
  private LocalDate lastBreeding;

  @Column(name = "birth_date", nullable = false)
  private LocalDate birthDate;

  @Column(name = "registered_with_government", nullable = false)
  private boolean registeredWithGovernment;

  @Column(name = "receive_notifications", nullable = false)
  private boolean receiveNotifications;

  @Column(name = "image_url", nullable = true)
  private String imageUrl;

  // Getters e Setters

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

  public void setRGD(String RGD) {
    this.RGD = RGD;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Animal getFather() {
    return father;
  }

  public void setFather(Animal father) {
    this.father = father;
  }

  public Animal getMother() {
    return mother;
  }

  public void setMother(Animal mother) {
    this.mother = mother;
  }

  public List<Animal> getOffspringAsFather() {
    return offspringAsFather;
  }

  public void setOffspringAsFather(List<Animal> offspringAsFather) {
    this.offspringAsFather = offspringAsFather;
  }

  public List<Animal> getOffspringAsMother() {
    return offspringAsMother;
  }

  public void setOffspringAsMother(List<Animal> offspringAsMother) {
    this.offspringAsMother = offspringAsMother;
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
}
