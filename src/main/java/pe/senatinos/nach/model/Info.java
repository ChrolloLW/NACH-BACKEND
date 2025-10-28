package pe.nach.model;

public class Info {
    private String nombre;
    private String version;
    private String estado;

    // Constructor
    public Info(String nombre, String version, String estado) {
        this.nombre = nombre;
        this.version = version;
        this.estado = estado;
    }

    // Getters (obligatorios para que Spring los serialice a JSON)
    public String getNombre() {
        return nombre;
    }

    public String getVersion() {
        return version;
    }

    public String getEstado() {
        return estado;
    }
}
