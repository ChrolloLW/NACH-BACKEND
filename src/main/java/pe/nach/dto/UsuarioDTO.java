package pe.nach.dto;

import java.sql.Timestamp;

public class UsuarioDTO {
  private Long idUsuario;
  private String nombreUsuario;
  private Integer activo;        // 1 = activo, 0 = inactivo
  private Integer adminSistema;  // 1 = admin, 0 = no
  private Timestamp lastLoginDate;

  // getters/setters
  public Long getIdUsuario() { return idUsuario; }
  public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
  public String getNombreUsuario() { return nombreUsuario; }
  public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
  public Integer getActivo() { return activo; }
  public void setActivo(Integer activo) { this.activo = activo; }
  public Integer getAdminSistema() { return adminSistema; }
  public void setAdminSistema(Integer adminSistema) { this.adminSistema = adminSistema; }
  public Timestamp getLastLoginDate() { return lastLoginDate; }
  public void setLastLoginDate(Timestamp lastLoginDate) { this.lastLoginDate = lastLoginDate; }
}
