package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona", indexes = {
    @Index(name = "persona_Cod_Fox", columnList = "Cod_Fox")
})
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Persona")
    private Integer id;

    @Column(name = "Nombre", length = 100)
    private String nombre;

    @Column(name = "Apellido_Paterno", length = 50)
    private String apellidoPaterno;

    @Column(name = "Apellido_Materno", length = 50)
    private String apellidoMaterno;

    @Column(name = "Razon_Social", length = 100)
    private String razonSocial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo_Persona", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo_Persona", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle tipoPersona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo_Documento", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo_Documento", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle tipoDocumento;

    @Column(name = "Numero_Documento", length = 20)
    private String numeroDocumento;

    @Column(name = "Numero_Ruc", length = 20)
    private String numeroRuc;

    @Column(name = "Persona_Contacto", length = 200)
    private String personaContacto;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Compania", nullable = false)
    private Compania compania;

    @Column(name = "Cod_Fox", length = 6)
    private String codigoFox;

    @Column(name = "Comentario", length = 500)
    private String comentario;

    @Column(name = "Deleted")
    private Boolean deleted;

    @Column(name = "Es_Extranjero")
    private Boolean esExtranjero;

    @Column(name = "emp_cod")
    private Integer empCod;

    @Column(name = "num_area")
    private Integer numArea;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}