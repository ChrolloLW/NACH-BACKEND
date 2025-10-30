package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.EmpleadoHorario;

@Repository
public interface EmpleadoHorarioRepository extends JpaRepository<EmpleadoHorario, Integer> {
}