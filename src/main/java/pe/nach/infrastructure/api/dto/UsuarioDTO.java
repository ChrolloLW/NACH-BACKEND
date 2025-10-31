package pe.nach.infrastructure.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;
    private String nombreUsuario;
    private Integer activo;
    private Integer adminSistema;
    private LocalDateTime lastLoginDate;
    private String token;
}