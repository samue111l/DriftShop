package com.proyectoServidor.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Integer marcaid;

    @Column(name = "marca", nullable = false)
    String nombre;

    // Constructors
    public Marca(Integer marcaid, String nombre) {
        this.marcaid = marcaid;
        this.nombre = nombre;
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Marca() {
    }

    // Getters and Setters
    public Integer getMarcaid() {
        return marcaid;
    }

    public void setMarcaid(Integer marcaid) {
        this.marcaid = marcaid;
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
        return "Marca{" +
                "marcaid=" + marcaid +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

