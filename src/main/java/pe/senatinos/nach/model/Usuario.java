package pe.nach.model;


import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "usuario")
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IdUsuario")
private Long idUsuario;


@Column(name = "NombreUsuario")
private String nombreUsuario;


@Column(name = "password")
private String password;


@Column(name = "Activo")
private Integer activo; // 1=activo, 0=inactivo


@Column(name = "Admin_Sistema")
private Integer adminSistema; // 1=admin, 0=no


@Column(name = "fechaCreacion")
private Timestamp fechaCreacion;


@Column(name = "fechaActualizacion")
private Timestamp fechaActualizacion;


@Column(name = "LastLoginDate")
private Timestamp lastLoginDate;


// Getters/Setters
public Long getIdUsuario() { return idUsuario; }
public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }


public String getNombreUsuario() { return nombreUsuario; }
public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }


public String getPassword() { return password; }
public void setPassword(String password) { this.password = password; }


public Integer getActivo() { return activo; }
public void setActivo(Integer activo) { this.activo = activo; }


public Integer getAdminSistema() { return adminSistema; }
public void setAdminSistema(Integer adminSistema) { this.adminSistema = adminSistema; }


public Timestamp getFechaCreacion() { return fechaCreacion; }
public void setFechaCreacion(Timestamp fechaCreacion) { this.fechaCreacion = fechaCreacion; }


public Timestamp getFechaActualizacion() { return fechaActualizacion; }
public void setFechaActualizacion(Timestamp fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }


public Timestamp getLastLoginDate() { return lastLoginDate; }
public void setLastLoginDate(Timestamp lastLoginDate) { this.lastLoginDate = lastLoginDate; }
}
