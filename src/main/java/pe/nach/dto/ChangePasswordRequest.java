package pe.nach.dto;


public class ChangePasswordRequest {
private Long idUsuario;
private String passwordActual;
private String passwordNueva;


public Long getIdUsuario() { return idUsuario; }
public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }


public String getPasswordActual() { return passwordActual; }
public void setPasswordActual(String passwordActual) { this.passwordActual = passwordActual; }


public String getPasswordNueva() { return passwordNueva; }
public void setPasswordNueva(String passwordNueva) { this.passwordNueva = passwordNueva; }
}
