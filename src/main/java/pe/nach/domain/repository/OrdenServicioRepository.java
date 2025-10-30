package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.OrdenServicio;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Integer> {
}
