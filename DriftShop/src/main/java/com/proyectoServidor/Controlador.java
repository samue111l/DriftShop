package com.proyectoServidor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Controlador {

    private ModeloDB modeloDB;

    public Controlador(ModeloDB modeloDB) {
        this.modeloDB = modeloDB;
    }

    @GetMapping("/registrarUsuario")
    public String registrarUSuario(
        @RequestParam("nombreRegistro") String nombreRegistro,
        @RequestParam("contrasenaRegistro") String contrasenaRegistro,
        @RequestParam("correoRegistro") String correoRegistro,
        Model model){
            Usuario nuevoUsuario = modeloDB.registrarUSuario(nombreRegistro, contrasenaRegistro, correoRegistro);
            model.addAttribute("nuevoUsuario", nuevoUsuario);
            return "index";
    }

    @GetMapping("/login")
    public String login(
        @RequestParam("nombreRegistro") String nombreRegistro,
        @RequestParam("contrasenaRegistro") String contrasenaRegistro,
        Model model){
            Usuario usuario = modeloDB.validarInicioSesion(nombreRegistro, contrasenaRegistro);

            if (usuario != null) {
                model.addAttribute("usuario", usuario);
                return "redirect:/tienda";
            } else {
                return "redirect:/";
            }
    }

    @GetMapping("/listar")
    public String mostrarVista(Model model) {
        List<Producto> productos = modeloDB.listarProductos();
        model.addAttribute("productos", productos);
        return "index";
    }

    @GetMapping("/tienda")
    public String tienda(@RequestParam String name) {
        return "redirect:/";
    }

    @GetMapping("/taller")
    public String taller(@RequestParam String name) {
        return "redirect:/";
    }
}
