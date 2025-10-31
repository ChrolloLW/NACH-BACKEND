package pe.nach.domain.entity.servicios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import pe.nach.domain.entity.catalogos.CatalogoDetalle;
import pe.nach.domain.entity.empresa.Compania;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servicio", indexes = {
    @Index(name = "servicio_Cod_Fox", columnList = "Cod_Fox"),
    @Index(name = "servicio_Id_Servicio_IDX", columnList = "Id_Servicio"),
    @Index(name = "servicio_Descripcion_IDX", columnList = "Descripcion"),
    @Index(name = "servicio_Id_Catalogo_Clase_Servicio_IDX", columnList = "Id_Catalogo_Clase_Servicio"),
    @Index(name = "servicio_Id_Catalogo_Detalle_Clase_Servicio_IDX", columnList = "Id_Catalogo_Detalle_Clase_Servicio"),
    @Index(name = "servicio_Id_Catalogo_Grupo_Servicio_IDX", columnList = "Id_Catalogo_Grupo_Servicio"),
    @Index(name = "servicio_Estado_Registro_IDX", columnList = "Estado_Registro")
})
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Servicio")
    private Integer id;

    @Column(name = "Descripcion", nullable = false, length = 100)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Clase_Servicio", referencedColumnName = "Id_Catalogo", nullable = false),
        @JoinColumn(name = "Id_Catalogo_Detalle_Clase_Servicio", referencedColumnName = "Id_Catalogo_Detalle", nullable = false)
    })
    private CatalogoDetalle claseServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Grupo_Servicio", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Grupo_Servicio", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle grupoServicio;

    @Column(name = "Detalle", length = 500)
    private String detalle;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Compania", nullable = false)
    private Compania compania;

    @Column(name = "Cod_Fox", length = 6)
    private String codigoFox;

    @Column(name = "Tiempo_Promedio", precision = 10, scale = 2)
    private BigDecimal tiempoPromedio;

    @Column(name = "Tiene_Igv")
    private Boolean tieneIgv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo_Afectacion_Igv", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo_Afectacion_Igv", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle tipoAfectacionIgv;

    @Column(name = "Deleted")
    private Boolean deleted;

    @Column(name = "Codigo_Producto_Sunat", length = 45)
    private String codigoProductoSunat;

    @Column(name = "Codigo_Servicio", length = 50)
    private String codigoServicio;

    @Column(name = "Costo_Hora_Hombre", precision = 25, scale = 15)
    private BigDecimal costoHoraHombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Moneda", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Moneda", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle moneda;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}
