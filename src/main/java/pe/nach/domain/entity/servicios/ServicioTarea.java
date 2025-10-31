package pe.nach.domain.entity.servicios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import pe.nach.domain.entity.catalogos.CatalogoDetalle;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servicio_tarea")
public class ServicioTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Servicio_Tarea")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Servicio", nullable = false)
    private Servicio servicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Tarea", nullable = false)
    private Tarea tarea;

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

    @Column(name = "Deleted", nullable = false)
    private Boolean deleted;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;
}
