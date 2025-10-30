package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.PersonaTelefono;

@Repository
public interface PersonaTelefonoRepository extends JpaRepository<PersonaTelefono, Integer> {
}