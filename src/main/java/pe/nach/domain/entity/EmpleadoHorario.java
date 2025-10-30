package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado_horario")
public class EmpleadoHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Empleado_Horario")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Horario")
    private Horario horario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Persona")
    private Persona persona;

    @Column(name = "Fecha_Inicio")
    private LocalDate fechaInicio;

    @Column(name = "Fecha_Fin")
    private LocalDate fechaFin;

    @Column(name = "idHorario")
    private Integer idHorarioLegacy;

    @Column(name = "idEmpleado")
    private Integer idEmpleadoLegacy;

    @Column(name = "creadoPor", length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;
}