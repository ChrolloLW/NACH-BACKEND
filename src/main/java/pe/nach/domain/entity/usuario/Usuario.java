package pe.nach.domain.entity.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

    @Id
    @Column(name = "IdUsuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "NombreUsuario")
    private String nombreUsuario;

    @Column(name = "password")
    private String password;

    @Column(name = "Activo")
    private Integer activo;

    @Column(name = "Admin_Sistema")
    private Integer adminSistema;

    @Column(name = "creadoPor")
    private String creadoPor;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "actualizadoPor")
    private String actualizadoPor;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "LastLoginDate")
    private LocalDateTime lastLoginDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return activo != null && activo == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activo != null && activo == 1;
    }
}
