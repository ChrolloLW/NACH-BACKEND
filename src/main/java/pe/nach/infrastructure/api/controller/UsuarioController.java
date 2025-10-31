package pe.nach.infrastructure.api.controller;

import java.util.Map;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import pe.nach.dto.UsuarioDTO;
import pe.nach.domain.service.UsuarioService;

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
    public ResponseEntity<UsuarioDTO> obtener(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtener(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@RequestBody Map<String,Object> body) {
        String nombreUsuario = (String) body.get("nombreUsuario");
        String password = (String) body.get("password");
        Integer activo = (Integer) body.get("activo");
        Integer adminSistema = (Integer) body.get("adminSistema");
        return ResponseEntity.ok(service.crear(nombreUsuario, password, activo, adminSistema));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(
            @PathVariable Integer id,
            @RequestBody Map<String,Object> body) {
        String nombreUsuario = (String) body.get("nombreUsuario");
        Integer activo = (Integer) body.get("activo");
        Integer adminSistema = (Integer) body.get("adminSistema");
        return ResponseEntity.ok(service.actualizar(id, nombreUsuario, activo, adminSistema));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok().build();
    }
}