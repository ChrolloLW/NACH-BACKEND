package pe.nach.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.nach.infrastructure.security.JwtService;
import pe.nach.security.dto.AuthRequest;
import pe.nach.security.dto.AuthResponse;
import pe.nach.security.dto.RegisterRequest;
import pe.nach.domain.entity.usuario.Usuario;
import pe.nach.domain.repository.UsuarioRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var user = Usuario.builder()
                .nombreUsuario(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .activo(1)
                .adminSistema(0)
                .creadoPor("SYSTEM")
                .fechaCreacion(LocalDateTime.now())
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByNombreUsuario(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}