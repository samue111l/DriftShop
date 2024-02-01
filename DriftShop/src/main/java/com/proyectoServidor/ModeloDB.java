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
        System.out.println("Sentence: " + sqlSentence);  // verificación en consola

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
}
