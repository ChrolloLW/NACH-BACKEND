package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
}