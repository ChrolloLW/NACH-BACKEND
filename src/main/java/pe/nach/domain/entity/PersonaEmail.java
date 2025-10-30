package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona_email")
public class PersonaEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Persona_Email")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Persona", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo_Email", referencedColumnName = "Id_Catalogo", nullable = false),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo_Email", referencedColumnName = "Id_Catalogo_Detalle", nullable = false)
    })
    private CatalogoDetalle tipoEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Estado_Email", referencedColumnName = "Id_Catalogo", nullable = false),
        @JoinColumn(name = "Id_Catalogo_Detalle_Estado_Email", referencedColumnName = "Id_Catalogo_Detalle", nullable = false)
    })
    private CatalogoDetalle estadoEmail;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Cod_Fox", length = 6)
    private String codigoFox;

    @Column(name = "Comentario", length = 200)
    private String comentario;
}