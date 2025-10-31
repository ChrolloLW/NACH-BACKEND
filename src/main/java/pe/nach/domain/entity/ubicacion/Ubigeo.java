package pe.nach.domain.entity.ubicacion;

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
@Table(name = "ubigeo")
public class Ubigeo {
    @Id
    @Column(name = "Cod_ubigeo", length = 6)
    private String codigo;

    @Column(name = "Cod_dpto", nullable = false, length = 2)
    private String codigoDepartamento;

    @Column(name = "Cod_prov", nullable = false, length = 2)
    private String codigoProvincia;

    @Column(name = "Cod_dist", nullable = false, length = 2)
    private String codigoDistrito;

    @Column(name = "Descripcion", nullable = false, length = 50)
    private String descripcion;
}
