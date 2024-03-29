package com.proyectoServidor.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "marca", nullable = false)
    String nombre;

    // Constructors
    public Marca(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Marca() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long marcaid) {
        this.id = marcaid;
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
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
