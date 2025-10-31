package pe.nach.domain.entity.documentos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipo_cambio")
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Tipo_Cambio")
    private Integer id;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Valor_Compra", precision = 10, scale = 4, nullable = false)
    private BigDecimal valorCompra;

    @Column(name = "Valor_Venta", precision = 10, scale = 4, nullable = false)
    private BigDecimal valorVenta;

    @Column(name = "Estado_Registro", nullable = false)
    private Integer estadoRegistro;

    @Column(name = "creadoPor", length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;
}