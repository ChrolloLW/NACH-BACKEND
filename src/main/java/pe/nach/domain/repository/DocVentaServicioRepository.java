package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.DocVentaServicio;

@Repository
public interface DocVentaServicioRepository extends JpaRepository<DocVentaServicio, Integer> {
}
