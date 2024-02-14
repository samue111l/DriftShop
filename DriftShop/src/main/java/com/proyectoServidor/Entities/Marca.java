package com.proyectoServidor.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Marcaid;
    String nombre;
    public int getMarcaid() {
        return Marcaid;
    }
    public void setMarcaid(int marcaid) {
        Marcaid = marcaid;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Marca(int marcaid, String nombre) {
        Marcaid = marcaid;
        this.nombre = nombre;
    }
    public Marca(String nombre) {
        this.nombre = nombre;
    }
    public Marca() {
    }
    

    
    
}
