package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.catalogos.CatalogoDetalle;
import pe.nach.domain.entity.catalogos.CatalogoDetalleId;

@Repository
public interface CatalogoDetalleRepository extends JpaRepository<CatalogoDetalle, CatalogoDetalleId> {
}
