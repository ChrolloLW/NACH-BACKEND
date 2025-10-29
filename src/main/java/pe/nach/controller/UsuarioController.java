package pe.nach.controller;

import java.util.Map;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import pe.nach.dto.UsuarioDTO;
import pe.nach.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

  private final UsuarioService service;

  @GetMapping
  public ResponseEntity<List<UsuarioDTO>> listar(@RequestParam(value="q", required=false) String q) {
    return ResponseEntity.ok(service.listar(q));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioDTO> obtener(@PathVariable Long id) {
    return ResponseEntity.ok(service.obtener(id));
  }

  @PostMapping
  public ResponseEntity<UsuarioDTO> crear(@RequestBody Map<String,Object> body) {
    String nombreUsuario = (String) body.get("nombreUsuario");
    String password = (String) body.get("password");
    Integer activo = body.get("activo") != null ? (Integer) body.get("activo") : 1;
    Integer admin = body.get("adminSistema") != null ? (Integer) body.get("adminSistema") : 0;
    return ResponseEntity.ok(service.crear(nombreUsuario, password, activo, admin));
  }

  @PutMapping("/{id}")
  public ResponseEntity<UsuarioDTO> actualizar(@PathVariable Long id, @RequestBody Map<String,Object> body) {
    String nombreUsuario = (String) body.get("nombreUsuario");
    Integer activo = (Integer) body.get("activo");
    Integer admin = (Integer) body.get("adminSistema");
    return ResponseEntity.ok(service.actualizar(id, nombreUsuario, activo, admin));
  }

  @PatchMapping("/{id}/password")
  public ResponseEntity<?> cambiarPassword(@PathVariable Long id, @RequestBody Map<String,String> body) {
    service.cambiarPassword(id, body.get("password"));
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> eliminar(@PathVariable Long id) {
    service.eliminar(id);
    return ResponseEntity.noContent().build();
  }
}
