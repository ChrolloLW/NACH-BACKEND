package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.marcas.MarcaArticulo;

@Repository
public interface MarcaArticuloRepository extends JpaRepository<MarcaArticulo, Integer> {
}
