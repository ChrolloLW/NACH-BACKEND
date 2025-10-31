package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.almacen.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
}
