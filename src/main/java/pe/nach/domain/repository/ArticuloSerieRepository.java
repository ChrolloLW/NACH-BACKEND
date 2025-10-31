package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.articulos.ArticuloSerie;

@Repository
public interface ArticuloSerieRepository extends JpaRepository<ArticuloSerie, Integer> {
}
