package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "doc_venta")
public class DocVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Doc_Venta")
    private Integer id;

    @Column(name = "Serie_Doc_Venta", length = 4)
    private String serie;

    @Column(name = "Numero_Doc_Venta", length = 50)
    private String numero;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Observacion", length = 500)
    private String observacion;

    @Column(name = "Id_Catalogo_Estado", nullable = false)
    private Integer idCatalogoEstado;

    @Column(name = "Id_Catalogo_Detalle_Estado", nullable = false) 
    private Integer idCatalogoDetalleEstado;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "Id_Local", nullable = false)
    private Local local;

    @Column(name = "Numero_Documento_Persona", length = 20)
    private String numeroDocumentoPersona;

    @Column(name = "Nombre_Persona", length = 100)
    private String nombrePersona;

    @Column(name = "Direccion", length = 100)
    private String direccion;

    @Column(name = "Id_Catalogo_Tipo_Documento_Persona", length = 50)
    private String idCatalogoTipoDocumentoPersona;

    @Column(name = "Id_Catalogo_Detalle_Tipo_Documento_Persona", length = 45)
    private String idCatalogoDetalleTipoDocumentoPersona;

    @ManyToOne
    @JoinColumn(name = "Id_Persona")
    private Persona persona;

    @Column(name = "Id_Catalogo_Tipo_Documento", nullable = false)
    private Integer idCatalogoTipoDocumento;

    @Column(name = "Id_Catalogo_Detalle_Tipo_Documento", nullable = false)
    private Integer idCatalogoDetalleTipoDocumento;

    @Column(name = "Ruc", length = 45)
    private String ruc;

    @Column(name = "SubTotal", precision = 25, scale = 15)
    private BigDecimal subTotal;

    @Column(name = "IGV", precision = 25, scale = 15)
    private BigDecimal igv;

    @Column(name = "Total", nullable = false, precision = 25, scale = 15)
    private BigDecimal total;

    @Column(name = "Id_Catalogo_Moneda")
    private Integer idCatalogoMoneda;

    @Column(name = "Id_Catalogo_Detalle_Moneda")
    private Integer idCatalogoDetalleMoneda;

    @Column(name = "Id_Tipo_Cambio")
    private Integer idTipoCambio;

    @Column(name = "Tipo_Cambio", precision = 25, scale = 15)
    private BigDecimal tipoCambioValor;

    @Column(name = "IGV_Tasa", precision = 25, scale = 15)
    private BigDecimal igvTasa;

    @Column(name = "Tiene_Glosa")
    private Boolean tieneGlosa;

    @Column(name = "Id_Catalogo_Tipo_Venta")
    private Integer idCatalogoTipoVenta;

    @Column(name = "Id_Catalogo_Detalle_Tipo_Venta") 
    private Integer idCatalogoDetalleTipoVenta;

    @Column(name = "Estado_Documento", length = 50)
    private String estadoDocumento;

    @Column(name = "Total_Deuda", precision = 25, scale = 15)
    private BigDecimal totalDeuda;

    @Column(name = "Total_Pagado", precision = 25, scale = 15)
    private BigDecimal totalPagado;

    @Column(name = "Es_Documento_Electronico")
    private Boolean esDocumentoElectronico;

    @Column(name = "Doc_Electronico_Content", columnDefinition = "LONGTEXT")
    private String docElectronicoContent;

    @ManyToOne
    @JoinColumn(name = "Referencia_Id_Doc_Venta")
    private DocVenta referenciaDocVenta;

    @OneToMany(mappedBy = "docVenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocVentaArticulo> articulos = new ArrayList<>();

    @OneToMany(mappedBy = "docVenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DocVentaServicio> servicios = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}
