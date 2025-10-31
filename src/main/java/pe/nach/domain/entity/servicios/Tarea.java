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
@Table(name = "tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Tarea")
    private Integer id;

    @Column(name = "Descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "Horas_Hombre", precision = 10, scale = 2)
    private BigDecimal horasHombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Moneda", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Moneda", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle moneda;

    @Column(name = "Costo", precision = 25, scale = 15)
    private BigDecimal costo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Compania", nullable = false)
    private Compania compania;

    @Column(name = "Deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "creadoPor", length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;
}
