package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articulo", indexes = {
    @Index(name = "articulo_Cod_Fox", columnList = "Cod_Fox"),
    @Index(name = "articulo_Cod_Marca_Fox", columnList = "Cod_Marca_Fox"),
    @Index(name = "articulo_Cod_Sublinea_Fox", columnList = "Cod_Sublinea_Fox"),
    @Index(name = "articulo_descripcion_idx", columnList = "Descripcion"),
    @Index(name = "articulo_codigo_fabricacion_idx", columnList = "Codigo_Fabricacion"),
    @Index(name = "articulo_Id_Articulo_IDX", columnList = "Id_Articulo"),
    @Index(name = "articulo_Codigo_Producto_IDX", columnList = "Codigo_Producto"),
    @Index(name = "articulo_Estado_Registro_IDX", columnList = "Estado_Registro")
})
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Articulo")
    private Integer id;

    @Column(name = "Descripcion", nullable = false, length = 100)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_SubLinea", nullable = false)
    private SublineaArticulo sublinea;

    @Column(name = "Codigo_Fabricacion", nullable = false, length = 20)
    private String codigoFabricacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Unidad_Medida", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Unidad_Medida", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle unidadMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Pais")
    private Pais pais;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Marca")
    private MarcaArticulo marca;

    @Column(name = "Flag_Serie")
    private Integer flagSerie;

    @Column(name = "Id_Compania", nullable = false)
    private Integer idCompania;

    @Column(name = "Cod_Fox", length = 10)
    private String codigoFox;

    @Column(name = "Cod_Marca_Fox", length = 6)
    private String codigoMarcaFox;

    @Column(name = "Cod_Sublinea_Fox", length = 6)
    private String codigoSublineaFox;

    @Column(name = "Codigo_Producto", length = 50)
    private String codigoProducto;

    @Column(name = "Id_Equivalencia", length = 45)
    private String idEquivalencia;

    @Column(name = "Aplicacion", length = 100)
    private String aplicacion;

    @Column(name = "Comentario", length = 500)
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Unidad_Medida_Globales")
    private UnidadMedidaGlobales unidadMedidaGlobal;

    @Column(name = "Tiene_Igv")
    private Boolean tieneIgv;

    @Column(name = "Tiene_Isc")
    private Boolean tieneIsc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo_Afectacion_Igv", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo_Afectacion_Igv", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle tipoAfectacionIgv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo_Sistema_Calculo_Isc", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo_Sistema_Calculo_Isc", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle tipoSistemaCalculoIsc;

    @Column(name = "Deleted")
    private Boolean deleted;

    @Column(name = "Tiene_Imagen_Predeterminada")
    private Integer tieneImagenPredeterminada;

    @Column(name = "Precio", precision = 10, scale = 2)
    private BigDecimal precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Moneda", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Moneda", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle moneda;

    @Column(name = "Codigo_Producto_Sunat", length = 45)
    private String codigoProductoSunat;

    @Column(name = "Tiene_Stock")
    private Boolean tieneStock;

    @Column(name = "Nom_Origen_Fox", length = 30)
    private String nombreOrigenFox;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo_Codigo_Barras", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo_Codigo_Barras", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle tipoCodigoBarras;

    @Column(name = "Codigo_Barras", length = 45)
    private String codigoBarras;

    @Lob
    @Column(name = "Imagen_Codigo_Barras")
    private byte[] imagenCodigoBarras;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tasa_Isc", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tasa_Isc", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle tasaIsc;

    @Column(name = "Insumo")
    private Boolean insumo;

    @Column(name = "Cod_Unidad_Fox", length = 2)
    private String codigoUnidadFox;

    @Column(name = "y_precio", precision = 15, scale = 4)
    private BigDecimal precioProcesado;

    @Column(name = "n_utilidad", precision = 15, scale = 4)
    private BigDecimal utilidad;

    @Column(name = "n_esperada", precision = 15, scale = 4)
    private BigDecimal esperada;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}