package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}