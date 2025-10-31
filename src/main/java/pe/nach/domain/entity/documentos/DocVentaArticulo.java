package pe.nach.domain.entity.documentos;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

import pe.nach.domain.entity.articulos.Articulo;
import pe.nach.domain.entity.catalogos.CatalogoDetalle;

@Data
@Entity
@Table(name = "doc_venta_articulo")
public class DocVentaArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Doc_Venta_Articulo")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Doc_Venta", nullable = false)
    private DocVenta docVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Articulo", nullable = false)
    private Articulo articulo;

    @Column(name = "Descripcion", length = 200)
    private String descripcion;

    @Column(name = "Importe", precision = 25, scale = 15)
    private BigDecimal importe;

    @Column(name = "Cantidad", precision = 10, scale = 2, nullable = false)
    private BigDecimal cantidad;

    @Column(name = "SubTotal", precision = 25, scale = 15, nullable = false)
    private BigDecimal subTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Unidad_Medida", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Unidad_Medida", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle unidadMedida;

    @Column(name = "Numero_Item")
    private Integer numeroItem;

    @Column(name = "Id_Kardex")
    private Integer idKardex;

    @Column(name = "Importe_Descuento", precision = 25, scale = 15)
    private BigDecimal importeDescuento;

    @Column(name = "Valor_Unitario", precision = 25, scale = 15)
    private BigDecimal valorUnitario;

    @Column(name = "Factor_Descuento", precision = 25, scale = 15)
    private BigDecimal factorDescuento;

    @Column(name = "Valor_Venta_Bruto", precision = 25, scale = 15)
    private BigDecimal valorVentaBruto;

}
