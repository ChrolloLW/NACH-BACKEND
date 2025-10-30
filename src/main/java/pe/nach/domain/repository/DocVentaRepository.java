package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.DocVenta;

@Repository
public interface DocVentaRepository extends JpaRepository<DocVenta, Integer> {
}
