package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.servicios.ServicioTarea;

@Repository
public interface ServicioTareaRepository extends JpaRepository<ServicioTarea, Integer> {
}
