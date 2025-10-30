package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {
}