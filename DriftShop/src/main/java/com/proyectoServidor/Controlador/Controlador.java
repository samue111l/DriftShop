package com.proyectoServidor.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.proyectoServidor.Database.ModeloDB;
import com.proyectoServidor.Entities.Marca;
import com.proyectoServidor.Entities.Producto;
import com.proyectoServidor.Entities.Usuario;

import java.io.Console;
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

    /*@GetMapping("/listar")
    public String mostrarVista(Model model) {
        List<Producto> productos = modeloDB.listarProductos();
        model.addAttribute("productos", productos);
        return "tienda";
    }*/

    @GetMapping("/tienda")
    public String tienda() {
        return "tienda";
    }

    @GetMapping("/taller")
    public String taller() {
        return "taller";
    }

    /*@GetMapping("/marcas")
    public @ResponseBody String getMarcas() {
        List<Marca> marcas = modeloDB.seleccionarMarca();
        System.out.println(marcas);
        Gson gson = new Gson();
        return gson.toJson(marcas);
    }*/

    @GetMapping("/marcas")
    public String getMarcas(Model model) {
        System.out.println("Ha pasado por el controlador");
        List<Marca> marcas = modeloDB.seleccionarMarca();
        model.addAttribute("marcas", marcas);
        return "index";
    }
}
