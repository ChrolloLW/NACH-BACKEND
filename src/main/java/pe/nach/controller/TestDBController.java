package pe.nach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestDBController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 1) Ping rápido a la BD
    @GetMapping("/test-db/ping")
    public String ping() {
        try {
            Integer one = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "✅ Ping OK (SELECT 1 -> " + one + ")";
        } catch (Exception e) {
            return "❌ Ping error: " + e.getMessage();
        }
    }

    // 2) Lista tablas reales del esquema activo (imsysdb)
    @GetMapping("/test-db/tables")
    public List<String> listTables() {
        return jdbcTemplate.queryForList(
            "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = DATABASE() ORDER BY TABLE_NAME",
            String.class
        );
    }

    // 3) Cuenta filas de la tabla indicada ?table=nombre
    @GetMapping("/test-db/count")
    public String count(@RequestParam("table") String table) {
        try {
            Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM `" + table + "`", Integer.class
            );
            return "✅ " + table + ": " + count + " filas";
        } catch (Exception e) {
            return "❌ Error al contar en '" + table + "': " + e.getMessage();
        }
    }

    // 4) Modo automático: prueba una lista de tablas típicas y usa la primera que exista
    @GetMapping("/test-db")
    public String autoCheck() {
        List<String> candidates = Arrays.asList(
            "usuario", "usuarios", "ot", "seguimiento", "facturacion", "perfil", "usuario_perfil"
        );
        for (String t : candidates) {
            try {
                Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `" + t + "`", Integer.class);
                return "✅ Conexión OK. Tabla detectada '" + t + "': " + count + " filas";
            } catch (Exception ignored) { }
        }
        List<String> existing = listTables();
        return "⚠️ Conexión OK, pero ninguna de las tablas candidatas existe. Tablas en BD: " + existing;
    }
}

