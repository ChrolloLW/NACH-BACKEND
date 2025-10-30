package pe.nach.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.nach.domain.entity.Compania;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania, Integer> {
    // Métodos personalizados si son necesarios
}