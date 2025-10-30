package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.PersonaDireccion;

@Repository
public interface PersonaDireccionRepository extends JpaRepository<PersonaDireccion, Integer> {
}