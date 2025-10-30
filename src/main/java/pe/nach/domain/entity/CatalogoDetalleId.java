package pe.nach.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoDetalleId implements Serializable {
    private Integer catalogoCabecera;
    private Integer idCatalogoDetalle;
}