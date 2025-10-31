package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.empresa.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {
}
