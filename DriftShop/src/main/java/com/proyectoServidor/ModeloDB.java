package com.proyectoServidor;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ModeloDB {

    private final JdbcTemplate jdbcTemplate;

    public ModeloDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Producto> listarProductos() {
        ArrayList<Producto> lista = new ArrayList<>();

        String sqlSentence = "SELECT * FROM productos";
        System.out.println("Sentence: " + sqlSentence);

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlSentence);
            for (Map<String, Object> row : rows) {
                lista.add(new Producto(
                        (Integer) row.get("id"),
                        (String) row.get("marca"),
                        (String) row.get("modelo"),
                        (String) row.get("motor"),
                        (String) row.get("nombre"),
                        (Float) row.get("precio"),
                        (String) row.get("urlImagen")
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public Usuario registrarUSuario(String nombreRegistro, String contraseñaRegistro, String correoRegistro){
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombreUsuario(nombreRegistro);
        usuarioNuevo.setContraseña(contraseñaRegistro);
        usuarioNuevo.setCorreo(correoRegistro);
        String sql = "INSERT INTO usuario (nombreUsuario, contraseña, correo) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, nombreRegistro, contraseñaRegistro, correoRegistro);
        return usuarioNuevo;
    }

    public Usuario validarInicioSesion(String nombreUsuario, String contraseña) {
        String sql = "SELECT * FROM usuario WHERE nombreUsuario = ? AND contraseña = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, nombreUsuario, contraseña);
    
        if (!rows.isEmpty()) {
            Map<String, Object> row = rows.get(0);
            return new Usuario(
                (Integer) row.get("id"),
                (String) row.get("nombreUsuario"),
                (String) row.get("contraseña"),
                (String) row.get("correo")
            );
        } else {
            return null;
        }
    }

    public List<Marca> seleccionarMarca() {
        ArrayList<Marca> lista = new ArrayList<>();

        String sqlSentence = "SELECT DISTINCT \"Nombre\" FROM marcas";
        System.out.println("Sentence: " + sqlSentence);  // verificación en consola

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlSentence);
            for (Map<String, Object> row : rows) {
                lista.add(new Marca(
                        (String) row.get("Nombre")
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(lista);
        return lista;
    }
    

    

}
