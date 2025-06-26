package CasoEstudioUTEC;

import java.util.Objects;

public class Psicopedagogo extends Usuario {

    private String sectorPsicopedagogia;
    private boolean accesoConfidencial;

    // Constructor básico
    public Psicopedagogo(String correoInstitucional) {
        super(correoInstitucional);
        this.accesoConfidencial = true;
    }

    // Constructor completo con validaciones
    public Psicopedagogo(String correoInstitucional, String nombre, String apellido, String fechaNacimiento,
                         String cedulaId, String ITR, Rol rol, String direccion, String sectorPsicopedagogia,
                         boolean accesoConfidencial) {
        super(
                Objects.requireNonNull(correoInstitucional, "Correo no puede ser null"),
                Objects.requireNonNull(nombre, "Nombre no puede ser null"),
                Objects.requireNonNull(apellido, "Apellido no puede ser null"),
                Objects.requireNonNull(fechaNacimiento, "Fecha de nacimiento no puede ser null"),
                Objects.requireNonNull(cedulaId, "Cédula no puede ser null"),
                Objects.requireNonNull(rol, "Rol no puede ser null"),
                direccion
        );
        this.sectorPsicopedagogia = sectorPsicopedagogia;
        this.accesoConfidencial = accesoConfidencial;
    }

    // Getters y Setters
    public String getSectorPsicopedagogia() {
        return sectorPsicopedagogia;
    }

    public void setSectorPsicopedagogia(String sectorPsicopedagogia) {
        this.sectorPsicopedagogia = sectorPsicopedagogia;
    }

    public boolean isAccesoConfidencial() {
        return accesoConfidencial;
    }

    public void setAccesoConfidencial(boolean accesoConfidencial) {
        this.accesoConfidencial = accesoConfidencial;
    }

    // Método para crear instancia de seguimiento (con validación)
    public InstanciaSeguimiento crearInstanciaSeguimiento(String titulo, String fechaString, String horaString,
                                                          String tipo, boolean confidencial,
                                                          Estudiante estudiante, String comentarios,
                                                          String campoConfidencial, boolean motivada) {
        if (estudiante == null) {
            throw new IllegalArgumentException("El estudiante no puede ser null al crear una instancia de seguimiento.");
        }

        return new InstanciaSeguimiento(titulo, fechaString, horaString, tipo, confidencial,
                estudiante, this, comentarios, campoConfidencial, motivada);
    }

    // Método para registrar un comentario
    public Comentario registrarComentario(String texto, boolean confidencial) {
        return new Comentario(this, texto, confidencial);
    }

    // Método para clasificar a un estudiante (con validación)
    public void clasificarEstudiante(Estudiante estudiante, String prioridad) {
        if (estudiante == null) {
            System.out.println("No se puede clasificar: estudiante es null.");
            return;
        }
        estudiante.setPrioridadSeguimiento(prioridad);
    }

    // Simulación de acceso a datos confidenciales
    public void accederADatosConfidenciales() {
        if (accesoConfidencial) {
            System.out.println("Psicopedagogo accediendo a datos confidenciales...");
        } else {
            System.out.println("Acceso denegado. No tienes permisos.");
        }
    }

    // Método toString corregido
    @Override
    public String toString() {
        return "Psicopedagogo: " + getNombre() + " " + getApellido() +
                " | CI: " + getCedulaIdentidad() +
                " | Email: " + getCorreoInstitucional();
    }
}
