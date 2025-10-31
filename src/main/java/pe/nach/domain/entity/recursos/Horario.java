package pe.nach.domain.entity.recursos;

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
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_horario")
    private Integer id;

    @Column(name = "Nombre_Horario", length = 100)
    private String nombreHorario;

    @Column(name = "Tolerancia")
    private Integer tolerancia;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Compania")
    private Compania compania;

    @Column(name = "idHorario")
    private Integer idHorarioLegacy;

    @Column(name = "creadoPor", length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;
}
