package pe.nach.domain.entity.articulos;

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
@Table(name = "sublinea_articulo", indexes = {
    @Index(name = "sublinea_articulo_Cod_Fox", columnList = "Cod_Fox"),
    @Index(name = "sublinea_articulo_Cod_Linea_Fox", columnList = "Cod_Linea_Fox"),
    @Index(name = "sublinea_articulo_descripcion_idx", columnList = "Descripcion")
})
public class SublineaArticulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_SubLinea")
    private Integer id;

    @Column(name = "Codigo_SubLinea", length = 20)
    private String codigoSubLinea;

    @Column(name = "Descripcion", nullable = false, length = 50)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Linea", nullable = false)
    private LineaArticulo linea;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @Column(name = "Cod_Fox", length = 6)
    private String codigoFox;

    @Column(name = "Cod_Linea_Fox", length = 6)
    private String codigoLineaFox;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}
