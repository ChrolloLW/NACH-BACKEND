package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "local")
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Local")
    private Integer id;

    @Column(name = "Descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "Direccion", nullable = false, length = 100)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_compania", nullable = false)
    private Compania compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cod_ubigeo", nullable = false)
    private Ubigeo ubigeo;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @Column(name = "Emails_Notificacion_Requerimiento", length = 200)
    private String emailsNotificacionRequerimiento;

    @Column(name = "Factura_Electronica_Serie", length = 4)
    private String facturaElectronicaSerie;

    @Column(name = "Boleta_Electronica_Serie", length = 4)
    private String boletaElectronicaSerie;

    @Column(name = "Nota_Credito_Factura_Serie", length = 4)
    private String notaCreditoFacturaSerie;

    @Column(name = "Nota_Credito_Boleta_Serie", length = 4)
    private String notaCreditoBoletaSerie;

    @Column(name = "Nota_Debito_Factura_Serie", length = 4)
    private String notaDebitoFacturaSerie;

    @Column(name = "Nota_Debito_Boleta_Serie", length = 4)
    private String notaDebitoBoletaSerie;

    @Column(name = "Guia_Remision_Electronica_Serie", length = 4)
    private String guiaRemisionElectronicaSerie;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}