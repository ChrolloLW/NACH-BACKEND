package pe.nach.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.nach.dto.UsuarioDTO;
import pe.nach.domain.entity.usuario.Usuario;
import pe.nach.domain.repository.UsuarioRepository;
import pe.nach.domain.service.mapper.UsuarioMapper;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public List<UsuarioDTO> listar(String q) {
        var list = (q == null || q.isBlank()) ? repo.findAll() : repo.searchByNombre(q);
        return list.stream().map(UsuarioMapper::toDto).collect(Collectors.toList());
    }

    public UsuarioDTO obtener(Integer id) {
        var u = repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return UsuarioMapper.toDto(u);
    }

    public UsuarioDTO crear(String nombreUsuario, String password, Integer activo, Integer adminSistema) {
        var u = new Usuario();
        u.setNombreUsuario(nombreUsuario);
        u.setPassword(encoder.encode(password)); // << cifrado
        u.setActivo(activo != null ? activo : 1);
        u.setAdminSistema(adminSistema != null ? adminSistema : 0);
        var saved = repo.save(u);
        return UsuarioMapper.toDto(saved);
    }

    public UsuarioDTO actualizar(Integer id, String nombreUsuario, Integer activo, Integer adminSistema) {
        var u = repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (nombreUsuario != null) u.setNombreUsuario(nombreUsuario);
        if (activo != null) u.setActivo(activo);
        if (adminSistema != null) u.setAdminSistema(adminSistema);
        return UsuarioMapper.toDto(repo.save(u));
    }

    public void cambiarPassword(Integer id, String newPassword) {
        var u = repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        u.setPassword(encoder.encode(newPassword));
        repo.save(u);
    }

    public void eliminar(Integer id) {
        repo.deleteById(id); // si prefieres soft delete, cambia por setActivo(0)
    }
}
