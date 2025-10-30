package pe.nach.service.mapper;

import pe.nach.dto.UsuarioDTO;
import pe.nach.domain.entity.Usuario;

public class UsuarioMapper {
  public static UsuarioDTO toDto(Usuario u) {
    UsuarioDTO d = new UsuarioDTO();
    d.setIdUsuario(u.getIdUsuario());
    d.setNombreUsuario(u.getNombreUsuario());
    d.setActivo(u.getActivo());
    d.setAdminSistema(u.getAdminSistema());
    d.setLastLoginDate(u.getLastLoginDate());
    return d;
  }
}

