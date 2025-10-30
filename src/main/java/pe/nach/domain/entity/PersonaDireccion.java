package pe.nach.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona_direccion")
public class PersonaDireccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Persona_Direccion")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Persona", nullable = false)
    private Persona persona;

    @Column(name = "Direccion", nullable = false, length = 100)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cod_ubigeo")
    private Ubigeo ubigeo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Tipo_Direccion", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Tipo_Direccion", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle tipoDireccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "Id_Catalogo_Estado_Direccion", referencedColumnName = "Id_Catalogo"),
        @JoinColumn(name = "Id_Catalogo_Detalle_Estado_Direccion", referencedColumnName = "Id_Catalogo_Detalle")
    })
    private CatalogoDetalle estadoDireccion;

    @Column(name = "Cod_Fox", length = 6)
    private String codigoFox;

    @Column(name = "c_depa_fox", length = 100)
    private String departamentoFox;

    @Column(name = "c_prov_fox", length = 100)
    private String provinciaFox;

    @Column(name = "c_dist_fox", length = 100)
    private String distritoFox;
}