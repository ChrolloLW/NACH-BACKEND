package pe.nach.domain.entity.catalogos;

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
@Table(name = "unidades_medida_unice")
public class UnidadesDeMedidaUnice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Unidad_Medida")
    private Integer id;

    @Column(name = "Descripcion", length = 100)
    private String descripcion;

    @Column(name = "Codigo", length = 20)
    private String codigo;

    @Column(name = "Codigo_Sunat", length = 20)
    private String codigoSunat;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @Column(name = "creadoPor", length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;
}