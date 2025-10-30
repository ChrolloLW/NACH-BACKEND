package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.PersonaEmail;

@Repository
public interface PersonaEmailRepository extends JpaRepository<PersonaEmail, Integer> {
}