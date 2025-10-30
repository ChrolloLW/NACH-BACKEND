package pe.nach.dto;

import java.time.LocalDateTime;

public class UsuarioDTO {
  private Integer idUsuario;
  private String nombreUsuario;
  private Integer activo;        // 1 = activo, 0 = inactivo
  private Integer adminSistema;  // 1 = admin, 0 = no
  private LocalDateTime lastLoginDate;

  // getters/setters
  public Integer getIdUsuario() { return idUsuario; }
  public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
  public String getNombreUsuario() { return nombreUsuario; }
  public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
  public Integer getActivo() { return activo; }
  public void setActivo(Integer activo) { this.activo = activo; }
  public Integer getAdminSistema() { return adminSistema; }
  public void setAdminSistema(Integer adminSistema) { this.adminSistema = adminSistema; }
  public LocalDateTime getLastLoginDate() { return lastLoginDate; }
  public void setLastLoginDate(LocalDateTime lastLoginDate) { this.lastLoginDate = lastLoginDate; }
}
