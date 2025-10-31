package pe.nach.domain.entity.almacen;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import pe.nach.domain.entity.empresa.Local;
import pe.nach.domain.entity.catalogos.CatalogoDetalle;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "almacen")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Almacen")
    private Integer id;

    @Column(name = "Descripcion", nullable = false, length = 50)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Local", nullable = false)
    private Local local;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo", referencedColumnName = "Id_Catalogo", nullable = false),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo", referencedColumnName = "Id_Catalogo_Detalle", nullable = false)
    })
    private CatalogoDetalle tipoAlmacen;

    @Column(name = "Estado_Registro")
    private Integer estadoRegistro;

    @Column(name = "Cod_Fox", length = 6)
    private String codigoFox;

    @Column(name = "Almacen_Principal")
    private Integer almacenPrincipal;

    @Column(name = "Enviar_Email_Estado_Stock")
    private Integer enviarEmailEstadoStock;

    @Column(name = "Email", length = 200)
    private String email;

    @Column(name = "creadoPor", nullable = false, length = 45)
    private String creadoPor;

    @Column(name = "actualizadoPor", length = 45)
    private String actualizadoPor;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;
}
