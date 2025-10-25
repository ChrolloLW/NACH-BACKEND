package pe.senatinos.nach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDBController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test-db")
    public String testDB() {
        try {
            // Cambia "usuario" por alguna tabla real de imsysdb, por ejemplo "ot" o "seguimiento"
            Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ot", Integer.class);
            return "✅ Conexión exitosa con la base de datos. Registros en 'ot': " + count;
        } catch (Exception e) {
            return "❌ Error al conectar con la base de datos: " + e.getMessage();
        }
    }
}
