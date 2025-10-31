package pe.nach.domain.entity.empresa;

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
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Area")
    private Integer id;

    @Column(name = "Descripcion", length = 100)
    private String descripcion;

    @Column(name = "num_area")
    private Integer numeroArea;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Compania", nullable = false)
    private Compania compania;

    @Column(name = "creadoPor", length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;
}
