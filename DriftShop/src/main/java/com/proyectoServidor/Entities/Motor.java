package com.proyectoServidor.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "motores")
public class Motor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "motor", nullable = false)
    String nombre;

    // Constructors
    public Motor(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Motor(String nombre) {
        this.nombre = nombre;
    }

    public Motor() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString method (for debugging/logging)
    @Override
    public String toString() {
        return "Motor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
