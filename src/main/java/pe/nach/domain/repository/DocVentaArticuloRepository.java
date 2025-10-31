package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.documentos.DocVentaArticulo;

@Repository
public interface DocVentaArticuloRepository extends JpaRepository<DocVentaArticulo, Integer> {
}
