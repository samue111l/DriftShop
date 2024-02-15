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
        return motorRepository.save(motornuevo);
    }

    public List<Motor> read() {
        return motorRepository.findAll();
    }

    public void eliminarPorNombre(String nombreMotor) {
        Motor motor = motorRepository.findByNombre(nombreMotor);
        if (motor != null) {
            motorRepository.delete(motor);
        }else{
            System.out.println("No hay motores");
        }
    }
}
