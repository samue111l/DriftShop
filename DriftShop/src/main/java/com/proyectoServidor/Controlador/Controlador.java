package com.proyectoServidor.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectoServidor.Database.MarcaService;
import com.proyectoServidor.Database.ModeloDB;
import com.proyectoServidor.Entities.Marca;
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

    @GetMapping("/tienda")
    public String tienda() {
        return "tienda";
    }

    @GetMapping("/taller")
    public String taller() {
        return "taller";
    }

    @GetMapping("/vermarcas")
    public String getMarcas(@RequestParam(name = "marcas", required = false) String verMarcas, Model model) {
        List<Marca> marcas;

        if ("ver".equals(verMarcas)) {
            System.out.println("LLega a controlador");
            marcas = marcaService.seleccionarMarca();

        } else {
            marcas = new ArrayList<>();
            marcas.add(new Marca(1, "Ejemplo random"));
            marcas.add(new Marca(2, "Ejemplo mas random aun"));
        }

        model.addAttribute("marcas", marcas);

        return "index";
    }
}
