package com.proyectoServidor.Entities;

public class Producto {
    
    int id;
    String marca;
    String modelo;
    String motor;
    String nombre;
    float precio;
    String urlImagen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Producto(int id, String marca, String modelo, String motor, String nombre, float precio, String urlImagen) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.nombre = nombre;
        this.precio = precio;
        this.urlImagen = urlImagen;
    }

    public Producto(String marca, String modelo, String motor, String nombre, float precio, String urlImagen) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.nombre = nombre;
        this.precio = precio;
        this.urlImagen = urlImagen;
    }
    
    
    
}
