package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "doc_venta_servicio")
public class DocVentaServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Doc_Venta_Servicio")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Doc_Venta", nullable = false)
    private DocVenta docVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Servicio", nullable = false)
    private Servicio servicio;

    @Column(name = "Cantidad", precision = 10, scale = 2, nullable = false)
    private BigDecimal cantidad;

    @Column(name = "Descripcion", length = 100, nullable = false)
    private String descripcion;

    @Column(name = "Importe", precision = 25, scale = 15, nullable = false)
    private BigDecimal importe;

    @Column(name = "SubTotal", precision = 25, scale = 15, nullable = false)
    private BigDecimal subTotal;

    @Column(name = "Numero_Item")
    private Integer numeroItem;

    @Column(name = "Importe_Descuento", precision = 25, scale = 15)
    private BigDecimal importeDescuento;

    @Column(name = "Valor_Unitario", precision = 25, scale = 15)
    private BigDecimal valorUnitario;

}
