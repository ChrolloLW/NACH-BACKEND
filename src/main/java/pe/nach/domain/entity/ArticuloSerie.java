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
@Table(name = "articulo_serie")
public class ArticuloSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Articulo_Serie")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Articulo", nullable = false)
    private Articulo articulo;

    @Column(name = "Numero_Serie", nullable = false, length = 50)
    private String numeroSerie;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}