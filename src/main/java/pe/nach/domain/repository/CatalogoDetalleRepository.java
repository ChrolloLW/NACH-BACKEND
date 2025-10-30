package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.CatalogoDetalle;
import pe.nach.domain.entity.CatalogoDetalleId;

@Repository
public interface CatalogoDetalleRepository extends JpaRepository<CatalogoDetalle, CatalogoDetalleId> {
}