package pe.nach.domain.entity.articulos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import pe.nach.domain.entity.empresa.Compania;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "linea_articulo", indexes = {
    @Index(name = "linea_articulo_Cod_Fox", columnList = "Cod_Fox"),
    @Index(name = "linea_articulo_descripcion", columnList = "Descripcion")
})
public class LineaArticulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Linea")
    private Integer id;

    @Column(name = "Codigo_Linea", length = 10)
    private String codigoLinea;

    @Column(name = "Descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Compania", nullable = false)
    private Compania compania;

    @Column(name = "Cod_Fox", length = 6)
    private String codigoFox;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}
