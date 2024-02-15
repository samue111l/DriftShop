package com.proyectoServidor.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectoServidor.Database.MarcaService;
import com.proyectoServidor.Database.ModeloDB;
import com.proyectoServidor.Database.MotorService;
import com.proyectoServidor.Entities.Marca;
import com.proyectoServidor.Entities.Motor;
import com.proyectoServidor.Entities.Producto;
import com.proyectoServidor.Entities.Usuario;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador {

    private ModeloDB modeloDB;

    public Controlador(ModeloDB modeloDB) {
        this.modeloDB = modeloDB;
    }

    @Autowired
    public MarcaService marcaService;
    @Autowired
    public MotorService motorService;

    @GetMapping("/registrarUsuario")
    public String registrarUSuario(
            @RequestParam("nombreRegistro") String nombreRegistro,
            @RequestParam("contrasenaRegistro") String contrasenaRegistro,
            @RequestParam("correoRegistro") String correoRegistro,
            Model model) {
        Usuario nuevoUsuario = modeloDB.registrarUSuario(nombreRegistro, contrasenaRegistro, correoRegistro);
        model.addAttribute("nuevoUsuario", nuevoUsuario);
        return "index";
    }

    @GetMapping("/login")
    public String login(
            @RequestParam("nombreRegistro") String nombreRegistro,
            @RequestParam("contrasenaRegistro") String contrasenaRegistro,
            Model model) {
        Usuario usuario = modeloDB.validarInicioSesion(nombreRegistro, contrasenaRegistro);

        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "redirect:/tienda";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/taller")
    public String taller() {
        return "taller";
    }

    @GetMapping("/tienda")
    public String tienda() {
        return "tienda";
    }

    @GetMapping("/readmarcas")
    public String readMarcas(@RequestParam(name = "marcas", required = false) String verMarcas, Model model) {
        List<Marca> marcas;

        switch (verMarcas) {
            case "ver":
                marcas = marcaService.getMarca();
                break;
            case "no ver":
                marcas = new ArrayList<>();
                marcas.add(new Marca((long) 1, "Ejemplo random"));
                marcas.add(new Marca((long) 2, "Ejemplo mas random aun"));
                break;

            default:
                marcas = new ArrayList<>();
                marcas.add(new Marca("Switch default"));
                break;
        }

        model.addAttribute("listamarcas", marcas);

        return "tienda";
    }

    @GetMapping("/añadirmotor")
    public String añadirMotor(@RequestParam("motor") String nombreMotor) {
        Motor nuevoMotor = new Motor();
        nuevoMotor.setNombre(nombreMotor);

        motorService.añadir(nuevoMotor);
        return "tienda";
    }

    @GetMapping("/readmotor")
    public String readMotor(Model model) {
        List<Motor> motores = motorService.read();
        model.addAttribute("listamotores", motores);
        return "tienda";
    }

    @GetMapping("/eliminarmotor")
    public String eliminarMotor(@RequestParam("motores") String nombreMotor) {
        motorService.eliminarPorNombre(nombreMotor);
        return "tienda";
    }
}
