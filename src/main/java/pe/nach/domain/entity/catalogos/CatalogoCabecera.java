package pe.nach.domain.entity.catalogos;

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
@Table(name = "catalogo_cabecera", indexes = {
    @Index(name = "catalogo_cabecera_Id_Catalogo_IDX", columnList = "Id_Catalogo"),
    @Index(name = "catalogo_cabecera_Descripcion_IDX", columnList = "Descripcion")
})
public class CatalogoCabecera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Catalogo")
    private Integer id;

    @Column(name = "Descripcion", nullable = false, length = 50)
    private String descripcion;
}
