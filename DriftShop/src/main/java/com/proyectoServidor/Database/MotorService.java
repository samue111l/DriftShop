package com.proyectoServidor.Database;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectoServidor.Entities.Motor;

@Service
public class MotorService {
    private MotorRepository motorRepository;

    public MotorService(MotorRepository motorRepository) {
        this.motorRepository = motorRepository;
    }

    public Motor añadir(Motor motornuevo) {
        System.out.println("Llega a controlador añadir motor");
        return motorRepository.save(motornuevo);
    }

    public List<Motor> read() {
        System.out.println("Llega a controlador read motor");
        return motorRepository.findAll();
    }

    public void eliminar(Motor motor) {
        System.out.println("Llega a controlador eliminar motor");
        motorRepository.delete(motor);
    }
}
