package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cotizacion_articulo")
public class CotizacionArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Cotizacion_Articulo")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Cotizacion", nullable = false)
    private Cotizacion cotizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Articulo")
    private Articulo articulo;

    @Column(name = "Descripcion", length = 500)
    private String descripcion;

    @Column(name = "Cantidad", precision = 10, scale = 2, nullable = false)
    private BigDecimal cantidad;

    @Column(name = "Valor_Unitario", precision = 25, scale = 15)
    private BigDecimal valorUnitario;

    @Column(name = "SubTotal", precision = 25, scale = 15)
    private BigDecimal subTotal;

    @Column(name = "Numero_Item")
    private Integer numeroItem;

}
