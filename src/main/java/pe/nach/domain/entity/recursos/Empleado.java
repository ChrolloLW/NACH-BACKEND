package pe.nach.domain.entity.recursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import pe.nach.domain.entity.personas.Persona;
import pe.nach.domain.entity.empresa.Area;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @Column(name = "Id_Persona")
    private Integer idPersona;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "Id_Persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Area")
    private Area area;
}
