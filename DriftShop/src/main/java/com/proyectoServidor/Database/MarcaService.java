package com.proyectoServidor.Database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.proyectoServidor.Entities.Marca;

@Service
public class MarcaService {
    private MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> getMarca() {
        System.out.println("Llega a controlador marca");
        return marcaRepository.findAll();
    }
}
