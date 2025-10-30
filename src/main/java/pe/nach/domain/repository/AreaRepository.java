package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
}