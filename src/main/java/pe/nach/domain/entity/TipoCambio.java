package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tipo_cambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Tipo_Cambio")
    private Integer id;

    @Column(name = "Monto", precision = 10, scale = 2, nullable = false)
    private BigDecimal monto;

    @Column(name = "Fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "Id_Catalogo_Moneda", nullable = false)
    private Integer idCatalogoMoneda;

    @Column(name = "Id_Catalogo_Detalle_Moneda", nullable = false)
    private Integer idCatalogoDetalleMoneda;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    @Column(name = "Id_Catalogo_Moneda_Principal", nullable = false)
    private Integer idCatalogoMonedaPrincipal;

    @Column(name = "Id_Catalogo_Detalle_Moneda_Principal", nullable = false)
    private Integer idCatalogoDetalleMonedaPrincipal;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @Column(name = "Id_Compania", nullable = false)
    private Integer idCompania;

}
