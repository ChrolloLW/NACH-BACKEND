package pe.nach.domain.entity.catalogos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class CatalogoDetalleId implements java.io.Serializable {
    @Column(name = "Id_Catalogo")
    private Integer idCatalogo;

    @Column(name = "Id_Catalogo_Detalle")
    private Integer idCatalogoDetalle;
}