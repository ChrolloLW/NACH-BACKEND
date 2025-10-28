package pe.nach.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.nach.dto.ChangePasswordRequest;
import pe.nach.dto.LoginRequest;
import pe.nach.model.Usuario;
import pe.nach.repository.UsuarioRepository;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;


@Service
public class AuthService {
private final UsuarioRepository usuarioRepository;


public AuthService(UsuarioRepository usuarioRepository) {
this.usuarioRepository = usuarioRepository;
}


public Optional<Usuario> login(LoginRequest req) {
return usuarioRepository.findByNombreUsuarioAndPasswordAndActivo(
req.getNombreUsuario(), req.getPassword(), 1);
}


@Transactional
public boolean actualizarLastLogin(Usuario u) {
u.setLastLoginDate(Timestamp.from(Instant.now()));
usuarioRepository.save(u);
return true;
}


@Transactional
public boolean cambiarPassword(ChangePasswordRequest req) {
Optional<Usuario> opt = usuarioRepository.findById(req.getIdUsuario());
if (opt.isEmpty()) return false;
Usuario u = opt.get();
if (!u.getPassword().equals(req.getPasswordActual())) return false;
u.setPassword(req.getPasswordNueva());
u.setFechaActualizacion(Timestamp.from(Instant.now()));
usuarioRepository.save(u);
return true;
}
}
