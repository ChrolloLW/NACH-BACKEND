package pe.nach.domain.entity.documentos;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

import pe.nach.domain.entity.servicios.Servicio;

@Data
@Entity
@Table(name = "orden_servicio_servicio")
public class OrdenServicioServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Orden_Servicio_Servicio")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Orden", nullable = false)
    private OrdenServicio ordenServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Servicio")
    private Servicio servicio;

    @Column(name = "Descripcion", length = 500)
    private String descripcion;

    @Column(name = "Cantidad", precision = 10, scale = 2)
    private BigDecimal cantidad;

    @Column(name = "Valor_Unitario", precision = 25, scale = 15)
    private BigDecimal valorUnitario;

    @Column(name = "Subtotal", precision = 25, scale = 15)
    private BigDecimal subTotal;

    @Column(name = "Numero_Item")
    private Integer numeroItem;

}
