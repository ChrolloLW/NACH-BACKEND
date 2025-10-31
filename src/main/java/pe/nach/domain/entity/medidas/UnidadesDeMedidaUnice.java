package pe.nach.domain.entity.medidas;

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
@Table(name = "unidades_de_medida_unice")
public class UnidadesDeMedidaUnice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Unidades_De_Medida_Unice")
    private Integer id;

    @Column(name = "Codigo", nullable = false, length = 45)
    private String codigo;

    @Column(name = "Nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "Descripcion", length = 1000)
    private String descripcion;

    @Column(name = "Nivel_Categoria", length = 45)
    private String nivelCategoria;

    @Column(name = "Simbolo", length = 45)
    private String simbolo;

    @Column(name = "Factor_Conversion", length = 45)
    private String factorConversion;

    @Column(name = "Estado", nullable = false)
    private Boolean estado;
}
