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
@Table(name = "compania")
public class Compania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_compania")
    private Integer id;

    @Column(name = "Razon_Social", nullable = false, length = 100)
    private String razonSocial;

    @Column(name = "Numero_ruc", nullable = false, length = 11)
    private String numeroRuc;

    @Column(name = "Nombre_Comercial", length = 100)
    private String nombreComercial;

    @Column(name = "Direccion", length = 100)
    private String direccion;

    @Column(name = "Telefono", length = 45)
    private String telefono;

    @Column(name = "Celular", length = 45)
    private String celular;

    @Column(name = "Correo", length = 45)
    private String correo;

    @Column(name = "Ciudad", length = 45)
    private String ciudad;

    @Column(name = "Pagina_Web", length = 200)
    private String paginaWeb;

    @Column(name = "Cod_Ubigeo", length = 45)
    private String codUbigeo;

    @Column(name = "Logo")
    @Lob
    private byte[] logo;

    @Column(name = "Logo_Ancho")
    private Integer logoAncho;

    @Column(name = "Logo_Alto")
    private Integer logoAlto;

    @Column(name = "Factura_Electronica")
    private Boolean facturaElectronica;

    @Column(name = "Mecanica_Automotriz")
    private Boolean mecanicaAutomotriz;

    @Column(name = "Cerveceria")
    private Boolean cerveceria;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}