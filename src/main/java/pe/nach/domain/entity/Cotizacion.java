package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cotizacion")
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Cotizacion")
    private Integer id;

    @Column(name = "Serie_Cotizacion")
    private Integer serie;

    @Column(name = "Numero_Cotizacion", length = 10, nullable = false)
    private String numero;

    @Column(name = "Version", length = 10)
    private String version;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Observacion", length = 500)
    private String observacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Persona")
    private Persona persona;

    @Column(name = "Id_Catalogo_Estado", nullable = false)
    private Integer idCatalogoEstado;

    @Column(name = "Id_Catalogo_Detalle_Estado", nullable = false)
    private Integer idCatalogoDetalleEstado;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "Id_Local", nullable = false)
    private Local local;

    @Column(name = "SubTotal", precision = 10, scale = 4)
    private BigDecimal subTotal;

    @Column(name = "IGV", precision = 10, scale = 4)
    private BigDecimal igv;

    @Column(name = "Total", precision = 10, scale = 4, nullable = false)
    private BigDecimal total;

    @Column(name = "Id_Catalogo_Moneda")
    private Integer idCatalogoMoneda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Tipo_Cambio")
    private TipoCambio tipoCambio;

    @Column(name = "Tipo_Cambio", precision = 10, scale = 4)
    private BigDecimal tipoCambioValor;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}
