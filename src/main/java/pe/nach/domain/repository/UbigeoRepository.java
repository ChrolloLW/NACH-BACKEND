package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.Ubigeo;

@Repository
public interface UbigeoRepository extends JpaRepository<Ubigeo, String> {
}