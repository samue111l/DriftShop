package com.proyectoServidor.Database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoServidor.Entities.Marca;

    @Service
    public class MarcaService {
        private MarcaRepository marcaRepository;

        @Autowired
        public MarcaService(MarcaRepository marcaRepository) {
            this.marcaRepository = marcaRepository;
        }

        public List<Marca> seleccionarMarca() {
            System.out.println("Llega a service");
            List<Marca> marcas = marcaRepository.findAll();
            if (marcas != null && !marcas.isEmpty()) {
                System.out.println("Hay marcas");
                for (Marca marca : marcas) {
                    System.out.println("Marca: " + marca.toString());
                }
            } else {
                System.out.println("No se encontraron marcas");
            }
            return marcas;
        }
    }
