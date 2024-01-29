package com.proyectoServidor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador {

    private List<Producto> productos = new ArrayList<>();

    // Constructor to initialize productos
    public Controlador() {
        productos.add(new Producto("motor1"));
        productos.add(new Producto("motor2"));
        productos.add(new Producto("motor3"));
    }

    @GetMapping("/listar")
    public String mostrarVista(Model model) {
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
