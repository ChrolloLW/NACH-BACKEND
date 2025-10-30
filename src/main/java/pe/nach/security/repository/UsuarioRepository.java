package pe.nach.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.nach.domain.entity.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}