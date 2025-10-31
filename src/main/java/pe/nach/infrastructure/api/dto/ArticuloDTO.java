package pe.nach.infrastructure.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloDTO {
    private Integer id;
    private String descripcion;
    private Integer idSublinea;
    private String codigoFabricacion;
    private Integer idUnidadMedida;
    private Integer idPais;
    private Integer estadoRegistro;
    private Integer idMarca;
    private Integer flagSerie;
    private Integer idCompania;
    private String codigoFox;
    private String codigoMarcaFox;
    private String codigoSublineaFox;
    private String codigoProducto;
    private String idEquivalencia;
    private String aplicacion;
    private String comentario;
    private Integer idUnidadMedidaGlobal;
    private Boolean tieneIgv;
    private Boolean tieneIsc;
}