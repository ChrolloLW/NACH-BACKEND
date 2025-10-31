package pe.nach.domain.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import pe.nach.domain.entity.empresa.Compania;
import pe.nach.domain.entity.documentos.DocVenta;
import pe.nach.domain.entity.empresa.Local;
import pe.nach.domain.entity.personas.Personas.Persona;
import pe.nach.domain.entity.ubicacion.Ubigeo;
import pe.nach.domain.repository.CompaniaRepository;
import pe.nach.domain.repository.DocVentaRepository;
import pe.nach.domain.repository.LocalRepository;
import pe.nach.domain.repository.PersonaRepository;
import pe.nach.domain.repository.UbigeoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@EntityScan(basePackageClasses = {
    Compania.class,
    Ubigeo.class,
    Local.class,
    Persona.class,
    DocVenta.class
})
@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=none"
})
@Transactional
public class DocVentaIntegrationTest {

    @Autowired
    private DocVentaRepository docVentaRepository;

    @Autowired
    private CompaniaRepository companiaRepository;

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UbigeoRepository ubigeoRepository;

    @Test
    public void saveDocVenta_withoutLines_shouldPersist() {
        // Given
        var compania = companiaRepository.findById(1).orElseThrow();
        var local = localRepository.findById(1).orElseThrow();
        var persona = personaRepository.findById(1).orElseThrow();
        
        var docVenta = new DocVenta();
        docVenta.setCompania(compania);
        docVenta.setLocal(local);
        docVenta.setPersona(persona);
        docVenta.setFechaEmision(LocalDate.now());
        docVenta.setFechaVencimiento(LocalDate.now().plusDays(30));
        docVenta.setMoneda("PEN");
        docVenta.setTipoCambio(new java.math.BigDecimal("3.70"));
        docVenta.setSubTotal(new java.math.BigDecimal("100.00"));
        docVenta.setIgv(new java.math.BigDecimal("18.00"));
        docVenta.setTotal(new java.math.BigDecimal("118.00"));
        
        // When
        var saved = docVentaRepository.save(docVenta);
        
        // Then
        assertThat(saved.getIdDocVenta()).isNotNull();
        assertThat(saved.getCompania().getIdCompania()).isEqualTo(compania.getIdCompania());
        assertThat(saved.getLocal().getIdLocal()).isEqualTo(local.getIdLocal());
        assertThat(saved.getPersona().getIdPersona()).isEqualTo(persona.getIdPersona());
    }
}
