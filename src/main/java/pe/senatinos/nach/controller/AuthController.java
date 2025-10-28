package pe.nach.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.nach.dto.ChangePasswordRequest;
import pe.nach.dto.LoginRequest;
import pe.nach.dto.LoginResponse;
import pe.nach.model.Usuario;
import pe.nach.service.AuthService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173"})
public class AuthController {


private final AuthService authService;


public AuthController(AuthService authService) {
this.authService = authService;
}


@PostMapping("/login")
public ResponseEntity<Object> login(@RequestBody LoginRequest req) {
    return authService.login(req)
            .map(u -> {
                authService.actualizarLastLogin(u);
                boolean admin = (u.getAdminSistema() != null && u.getAdminSistema() == 1);
                LoginResponse response = new LoginResponse(u.getIdUsuario(), u.getNombreUsuario(), admin);
                return ResponseEntity.ok((Object) response);
            })
            .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body((Object) "Credenciales inválidas"));
}


@PutMapping("/usuario/password")
public ResponseEntity<?> cambiarPassword(@RequestBody ChangePasswordRequest req) {
boolean ok = authService.cambiarPassword(req);
if (ok) return ResponseEntity.ok("Password actualizado");
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo actualizar el password");
}
}
