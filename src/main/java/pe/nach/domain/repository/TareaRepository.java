package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.servicios.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
}
