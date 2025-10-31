package pe.nach.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private Integer idCompania;
    private Integer idLocal;
    private Boolean adminSistema;
    private Boolean activo;
}
