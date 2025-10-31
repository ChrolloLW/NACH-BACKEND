package pe.nach.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UsuarioDTO {
    private Integer idUsuario;
    private String nombreUsuario;
    private Integer activo;
    private Integer adminSistema;
    private LocalDateTime lastLoginDate;
}