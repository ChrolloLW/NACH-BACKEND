package pe.nach.infrastructure.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DiagnosticController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/diagnostic/db/ping")
    public String ping() {
        try {
            Integer one = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "✅ Ping OK (SELECT 1 -> " + one + ")";
        } catch (Exception e) {
            return "❌ Ping error: " + e.getMessage();
        }
    }

    @GetMapping("/diagnostic/db/tables")
    public List<String> tables() {
        try {
            String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'imsysdb'";
            List<String> tables = jdbcTemplate.queryForList(query, String.class);
            return tables;
        } catch (Exception e) {
            return Arrays.asList("❌ Error: " + e.getMessage());
        }
    }

    @GetMapping("/diagnostic/db/query")
    public List<String> query(@RequestParam String sql) {
        try {
            return jdbcTemplate.queryForList(sql, String.class);
        } catch (Exception e) {
            return Arrays.asList("❌ Error: " + e.getMessage());
        }
    }
}