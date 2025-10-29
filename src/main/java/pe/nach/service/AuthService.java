package pe.nach.service;

import org.springframework.security.core.userdetails.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.nach.model.Usuario;
import pe.nach.repository.UsuarioRepository;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public Map<String, Object> login(String nombreUsuario, String password) {
        // 1️⃣ Buscar usuario por nombre
        Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 2️⃣ Verificar contraseña (BCrypt)
        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // 3️⃣ Validar que esté activo
        if (usuario.getActivo() != null && usuario.getActivo() == 0) {
            throw new RuntimeException("Usuario inactivo");
        }

        // 4️⃣ Autenticar con Spring Security
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(nombreUsuario, password)
        );

        // 5️⃣ Generar token JWT
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        // 6️⃣ Devolver respuesta
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("usuario", usuario);
        return response;
    }
}


