package pe.senatinos.nach.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/ping")
    public Map<String, String> ping() {
        return Map.of("status", "ok");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        if ("admin".equals(req.getUsername()) && "1234".equals(req.getPassword())) {
            return ResponseEntity.ok(Map.of(
                    "token", "fake-jwt-token",
                    "user", req.getUsername()
            ));
        }
        return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
    }

    // Clase interna para login
    public static class LoginRequest {
        private String username;
        private String password;
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
