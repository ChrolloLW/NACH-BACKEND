package pe.nach.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.nach.model.Info; // ✅ el import va aquí, junto a los otros

@RestController
public class HolaController {

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
