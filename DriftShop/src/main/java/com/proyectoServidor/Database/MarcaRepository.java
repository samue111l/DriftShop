package com.proyectoServidor.Database;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoServidor.Entities.Marca;

@Repository("marcarepository")
public interface MarcaRepository extends JpaRepository<Marca, Serializable> {
}

