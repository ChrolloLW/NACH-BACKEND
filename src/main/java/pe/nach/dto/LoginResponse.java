package pe.nach.dto;


public class LoginResponse {
private Long idUsuario;
private String nombreUsuario;
private boolean admin;


public LoginResponse(Long idUsuario, String nombreUsuario, boolean admin) {
this.idUsuario = idUsuario;
this.nombreUsuario = nombreUsuario;
this.admin = admin;
}


public Long getIdUsuario() { return idUsuario; }
public String getNombreUsuario() { return nombreUsuario; }
public boolean isAdmin() { return admin; }
}
