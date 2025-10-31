package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.personas.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
