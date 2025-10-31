package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.medidas.UnidadesDeMedidaUnice;

@Repository
public interface UnidadesDeMedidaUniceRepository extends JpaRepository<UnidadesDeMedidaUnice, Integer> {
}
