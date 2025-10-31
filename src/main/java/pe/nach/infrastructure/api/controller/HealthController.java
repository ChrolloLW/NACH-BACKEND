package pe.nach.infrastructure.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.nach.infrastructure.api.model.Info;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "✅ Servidor NACH funcionando correctamente";
    }

    @GetMapping("/hola")
    public String decirHola() {
        return "👋 Hola desde el backend NACH 🚀";
    }

    @GetMapping("/info")
    public Info mostrarInfo() {
        return new Info(
            "NACH Backend",
            "1.0.0",
            "✅ En ejecución"
        );
    }
}