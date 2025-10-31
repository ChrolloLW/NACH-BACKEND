package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.medidas.UnidadMedidaGlobales;

@Repository
public interface UnidadMedidaGlobalesRepository extends JpaRepository<UnidadMedidaGlobales, Integer> {
}
