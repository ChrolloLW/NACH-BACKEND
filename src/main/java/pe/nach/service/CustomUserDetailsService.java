package pe.nach.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.nach.model.Usuario;
import pe.nach.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + nombreUsuario));

        return User.builder()
                .username(user.getNombreUsuario())
                .password(user.getPassword())
                .roles(user.getAdminSistema() != null && user.getAdminSistema() == 1 ? "ADMIN" : "USER")
                .disabled(user.getActivo() != null && user.getActivo() == 0)
                .build();
    }
}
