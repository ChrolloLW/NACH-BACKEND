package pe.nach.domain.entity;

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
@Table(name = "marca_articulo", indexes = {
    @Index(name = "marca_articulo_Cod_Fox", columnList = "Cod_Fox"),
    @Index(name = "marca_descripcion_idx", columnList = "Descripcion")
})
public class MarcaArticulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Marca")
    private Integer id;

    @Column(name = "Descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Compania", nullable = false)
    private Compania compania;

    @Column(name = "Cod_Fox", length = 6)
    private String codigoFox;

    @Column(name = "Tipo_Fox", length = 1)
    private String tipoFox;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}