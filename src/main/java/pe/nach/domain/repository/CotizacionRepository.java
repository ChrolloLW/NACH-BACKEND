package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.documentos.Cotizacion;

@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, Integer> {
}
