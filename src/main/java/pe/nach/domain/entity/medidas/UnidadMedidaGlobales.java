package pe.nach.domain.entity.medidas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import pe.nach.domain.entity.catalogos.CatalogoDetalle;
import pe.nach.domain.entity.empresa.Compania;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unidad_medida_globales")
public class UnidadMedidaGlobales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Unidad_Medida_Globales")
    private Integer id;

    @Column(name = "Descripcion", nullable = false, length = 100)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Unidad_Medida_Base", referencedColumnName = "Id_Catalogo", nullable = false),
        @JoinColumn(name = "Id_Catalogo_Detalle_Unidad_Medida_Base", referencedColumnName = "Id_Catalogo_Detalle", nullable = false)
    })
    private CatalogoDetalle unidadMedidaBase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Compania", nullable = false)
    private Compania compania;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;
}
