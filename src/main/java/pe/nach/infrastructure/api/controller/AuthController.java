package pe.nach.infrastructure.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.nach.infrastructure.security.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> request) {
        String nombreUsuario = request.get("nombreUsuario");
        String password = request.get("password");

        Map<String, Object> response = authService.login(nombreUsuario, password);
        return ResponseEntity.ok(response);
    }
}