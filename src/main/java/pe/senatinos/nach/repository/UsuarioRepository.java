package pe.nach.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.nach.model.Usuario;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
Optional<Usuario> findByNombreUsuarioAndPasswordAndActivo(String nombreUsuario, String password, Integer activo);
}
