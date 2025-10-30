package pe.nach.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.nach.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    // 👇 Agregar este método para búsquedas parciales
    @Query("SELECT u FROM Usuario u WHERE (:q IS NULL OR LOWER(u.nombreUsuario) LIKE LOWER(CONCAT('%', :q, '%')))")
    List<Usuario> searchByNombre(@Param("q") String q);
}
