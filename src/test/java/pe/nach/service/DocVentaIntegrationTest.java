package pe.nach.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import pe.nach.domain.entity.Compania;
import pe.nach.domain.entity.DocVenta;
import pe.nach.domain.entity.Local;
import pe.nach.domain.entity.Persona;
import pe.nach.domain.entity.Ubigeo;
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
    pe.nach.domain.entity.Compania.class,
    pe.nach.domain.entity.Ubigeo.class,
    pe.nach.domain.entity.Local.class,
    pe.nach.domain.entity.Persona.class,
    pe.nach.domain.entity.DocVenta.class
})
@AutoConfigureTestDatabase(replace = Replace.ANY)
@TestPropertySource(properties = {
    // disable hibernate auto DDL for the test; we will create the minimal schema manually
    "spring.jpa.hibernate.ddl-auto=none"
})
public class DocVentaIntegrationTest {

    @Autowired
    private DocVentaRepository docVentaRepository;

    @Autowired
    private CompaniaRepository companiaRepository;

    @Autowired
    private UbigeoRepository ubigeoRepository;

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    @Transactional
    public void saveDocVenta_withoutLines_shouldPersist() {
        createSchema();

        Compania comp = new Compania();
        comp.setRazonSocial("ACME SA");
        comp.setNumeroRuc("20123456789");
        comp.setCreadoPor("test");
        comp.setFechaCreacion(LocalDateTime.now());
        comp.setFechaActualizacion(LocalDateTime.now());
        companiaRepository.save(comp);

        Ubigeo ub = new Ubigeo();
        ub.setCodigo("010101");
        ub.setCodigoDepartamento("01");
        ub.setCodigoProvincia("01");
        ub.setCodigoDistrito("01");
        ub.setDescripcion("Ubigeo Test");
        ubigeoRepository.save(ub);

        Local local = new Local();
        local.setDescripcion("Local Test");
        local.setDireccion("Calle 123");
        local.setCompania(comp);
        local.setUbigeo(ub);
        local.setCreadoPor("test");
        local.setFechaCreacion(LocalDateTime.now());
        local.setFechaActualizacion(LocalDateTime.now());
        localRepository.save(local);

        Persona p = new Persona();
        p.setNombre("Juan");
        p.setRazonSocial("Juan Perez");
        p.setCreadoPor("test");
        p.setFechaCreacion(LocalDateTime.now());
        p.setFechaActualizacion(LocalDateTime.now());
        p.setCompania(comp);
        personaRepository.save(p);

        DocVenta dv = new DocVenta();
        dv.setFecha(LocalDate.now());
        dv.setCreadoPor("test");
        dv.setFechaCreacion(LocalDateTime.now());
        dv.setFechaActualizacion(LocalDateTime.now());
        dv.setLocal(local);
        dv.setPersona(p);
        dv.setIdCatalogoEstado(1);
        dv.setIdCatalogoDetalleEstado(1);
        dv.setIdCatalogoTipoDocumento(1);
        dv.setIdCatalogoDetalleTipoDocumento(1);
        dv.setTotal(java.math.BigDecimal.ZERO);

        DocVenta saved = docVentaRepository.save(dv);
        assertThat(saved.getId()).isNotNull();
        assertThat(docVentaRepository.findById(saved.getId())).isPresent();
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private void createSchema() {
        // create minimal tables required by this test. Columns chosen to match the JPA mappings used in inserts.
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS compania (Id_compania INT AUTO_INCREMENT PRIMARY KEY, Razon_Social VARCHAR(100) NOT NULL, Numero_ruc VARCHAR(11) NOT NULL, Nombre_Comercial VARCHAR(100), Direccion VARCHAR(100), Telefono VARCHAR(45), Celular VARCHAR(45), Correo VARCHAR(45), Ciudad VARCHAR(45), Pagina_Web VARCHAR(200), Cod_Ubigeo VARCHAR(45), Logo BLOB, Logo_Ancho INT, Logo_Alto INT, Factura_Electronica BOOLEAN, Mecanica_Automotriz BOOLEAN, Cerveceria BOOLEAN, Estado_Registro INT, creadoPor VARCHAR(45) NOT NULL, actualizadoPor VARCHAR(45), fechaCreacion TIMESTAMP NOT NULL, fechaActualizacion TIMESTAMP NOT NULL)");

    jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS ubigeo (Cod_ubigeo VARCHAR(6) PRIMARY KEY, Cod_dpto VARCHAR(2) NOT NULL, Cod_prov VARCHAR(2) NOT NULL, Cod_dist VARCHAR(2) NOT NULL, Descripcion VARCHAR(50) NOT NULL)");

    jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS local (Id_Local INT AUTO_INCREMENT PRIMARY KEY, Descripcion VARCHAR(255), Direccion VARCHAR(255), Id_compania INT, Cod_ubigeo VARCHAR(6), creadoPor VARCHAR(45), actualizadoPor VARCHAR(45), fechaCreacion TIMESTAMP, fechaActualizacion TIMESTAMP, Emails_Notificacion_Requerimiento VARCHAR(200), Factura_Electronica_Serie VARCHAR(4), Boleta_Electronica_Serie VARCHAR(4), Nota_Credito_Factura_Serie VARCHAR(4), Nota_Credito_Boleta_Serie VARCHAR(4), Nota_Debito_Factura_Serie VARCHAR(4), Nota_Debito_Boleta_Serie VARCHAR(4), Guia_Remision_Electronica_Serie VARCHAR(4), Estado_Registro INT)");

    jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS persona (Id_Persona INT AUTO_INCREMENT PRIMARY KEY, Nombre VARCHAR(100), Apellido_Paterno VARCHAR(50), Apellido_Materno VARCHAR(50), Razon_Social VARCHAR(100), Id_Catalogo_Tipo_Persona INT, Id_Catalogo_Detalle_Tipo_Persona INT, Id_Catalogo_Tipo_Documento INT, Id_Catalogo_Detalle_Tipo_Documento INT, Numero_Documento VARCHAR(20), Numero_Ruc VARCHAR(20), Persona_Contacto VARCHAR(200), Estado_Registro INT, Id_Compania INT, Cod_Fox VARCHAR(6), Comentario VARCHAR(500), Deleted BOOLEAN, Es_Extranjero BOOLEAN, emp_cod INT, num_area INT, creadoPor VARCHAR(45), actualizadoPor VARCHAR(45), fechaCreacion TIMESTAMP, fechaActualizacion TIMESTAMP)");

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS doc_venta (Id_Doc_Venta INT AUTO_INCREMENT PRIMARY KEY, actualizadoPor VARCHAR(45), creadoPor VARCHAR(45), Direccion VARCHAR(100), Doc_Electronico_Content CLOB, Es_Documento_Electronico BOOLEAN, Estado_Documento VARCHAR(50), Fecha DATE, fechaActualizacion TIMESTAMP, fechaCreacion TIMESTAMP, Id_Catalogo_Detalle_Estado INT, Id_Catalogo_Detalle_Moneda INT, Id_Catalogo_Detalle_Tipo_Documento INT, Id_Catalogo_Detalle_Tipo_Documento_Persona VARCHAR(45), Id_Catalogo_Detalle_Tipo_Venta INT, Id_Catalogo_Estado INT, Id_Catalogo_Moneda INT, Id_Catalogo_Tipo_Documento INT, Id_Catalogo_Tipo_Documento_Persona VARCHAR(50), Id_Catalogo_Tipo_Venta INT, IGV DECIMAL(25,15), IGV_Tasa DECIMAL(25,15), Id_Local INT, Nombre_Persona VARCHAR(100), Numero_Doc_Venta VARCHAR(50), Numero_Documento_Persona VARCHAR(20), Observacion VARCHAR(500), Id_Persona INT, Referencia_Id_Doc_Venta INT, Ruc VARCHAR(45), Serie_Doc_Venta VARCHAR(4), SubTotal DECIMAL(25,15), Tiene_Glosa BOOLEAN, Id_Tipo_Cambio INT, Tipo_Cambio DECIMAL(25,15), Total DECIMAL(25,15), Total_Deuda DECIMAL(25,15), Total_Pagado DECIMAL(25,15))");
    }

}
