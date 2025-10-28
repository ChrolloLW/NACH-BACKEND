package pe.senatinos.nach.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean validarCredenciales(String username, String password) {
        // TODO: reemplazar por consulta real a la BD (usuario/clave)
        return "admin".equals(username) && "1234".equals(password);
    }
}
