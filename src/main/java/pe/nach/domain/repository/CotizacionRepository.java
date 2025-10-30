package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.Cotizacion;

@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, Integer> {
}
