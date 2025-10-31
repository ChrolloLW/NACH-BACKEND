package pe.nach.domain.entity.catalogos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import pe.nach.domain.entity.empresa.Compania;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "catalogo_detalle", indexes = {
    @Index(name = "catalogo_detalle_Id_Catalogo_Detalle_IDX", columnList = "Id_Catalogo_Detalle"),
    @Index(name = "catalogo_detalle_Descripcion_IDX", columnList = "Descripcion"),
    @Index(name = "catalogo_detalle_Valor_Texto_IDX", columnList = "Valor_Texto")
})
@IdClass(CatalogoDetalleId.class)
public class CatalogoDetalle {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Catalogo", nullable = false)
    private CatalogoCabecera catalogoCabecera;

    @Id
    @Column(name = "Id_Catalogo_Detalle", nullable = false)
    private Integer idCatalogoDetalle;

    @Column(name = "Descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "Valor_Texto", length = 200)
    private String valorTexto;

    @Column(name = "Valor_Texto2", length = 200)
    private String valorTexto2;

    @Column(name = "Valor_Texto3", length = 200)
    private String valorTexto3;

    @Column(name = "Valor_Texto_Grande1", columnDefinition = "TEXT")
    private String valorTextoGrande1;

    @Column(name = "Valor_Numero")
    private Double valorNumero;

    @Column(name = "Valor_Numero2")
    private Integer valorNumero2;

    @Column(name = "Valor_Numero_Decimal1", precision = 15, scale = 4)
    private BigDecimal valorNumeroDecimal1;

    @Column(name = "Valor_Numero_Integer2")
    private Integer valorNumeroInteger2;

    @Column(name = "Valor_Numero_Integer3")
    private Integer valorNumeroInteger3;

    @Column(name = "Valor_Bit1")
    private Boolean valorBit1;

    @Column(name = "Valor_Bit2")
    private Boolean valorBit2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Compania")
    private Compania compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Unidad_Medida")
    private UnidadesDeMedidaUnice unidadMedida;
}
