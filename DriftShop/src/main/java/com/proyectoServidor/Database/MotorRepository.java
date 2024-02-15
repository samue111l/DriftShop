package com.proyectoServidor.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectoServidor.Entities.Motor;

@Repository("motorepository")
public interface MotorRepository extends JpaRepository<Motor, Integer> {
}
