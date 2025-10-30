package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orden_servicio")
public class OrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Orden")
    private Integer id;

    @Column(name = "Serie_Orden")
    private Integer serie;

    @Column(name = "Numero_Orden", length = 10, nullable = false)
    private String numero;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Observacion", columnDefinition = "LONGTEXT")
    private String observacion;

    @Column(name = "Id_Catalogo_Estado", nullable = false)
    private Integer idCatalogoEstado;

    @Column(name = "Id_Catalogo_Detalle_Estado", nullable = false)
    private Integer idCatalogoDetalleEstado;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "Id_Local", nullable = false)
    private Local local;

    @Column(name = "Estado_Documento", length = 50)
    private String estadoDocumento;

    @ManyToOne
    @JoinColumn(name = "Id_Persona", nullable = false)
    private Persona persona;

    @Column(name = "Fecha_Entrega")
    private LocalDateTime fechaEntrega;

    @Column(name = "Fecha_Culminacion_Servicio")
    private LocalDateTime fechaCulminacionServicio;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
}
