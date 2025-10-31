package pe.nach.domain.entity.personas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import pe.nach.domain.entity.personas.Persona;
import pe.nach.domain.entity.catalogos.CatalogoDetalle;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona_telefono")
public class PersonaTelefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Persona_Telefono")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Persona", nullable = false)
    private Persona persona;

    @Column(name = "Numero_Telefono", nullable = false, length = 50)
    private String numeroTelefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo_Telefono", referencedColumnName = "Id_Catalogo", nullable = false),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo_Telefono", referencedColumnName = "Id_Catalogo_Detalle", nullable = false)
    })
    private CatalogoDetalle tipoTelefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Estado_Telefono", referencedColumnName = "Id_Catalogo", nullable = false),
        @JoinColumn(name = "Id_Catalogo_Detalle_Estado_Telefono", referencedColumnName = "Id_Catalogo_Detalle", nullable = false)
    })
    private CatalogoDetalle estadoTelefono;

    @Column(name = "Cod_Fox", length = 6)
    private String codigoFox;

    @Column(name = "Comentario", length = 200)
    private String comentario;
}
