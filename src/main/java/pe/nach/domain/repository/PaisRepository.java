package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
}