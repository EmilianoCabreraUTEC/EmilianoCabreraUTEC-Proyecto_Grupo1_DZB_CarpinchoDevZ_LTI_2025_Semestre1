package CasoEstudioUTEC;

public class Psicopedagogo extends Usuario {

    private String sectorPsicopedagogia;
    private boolean accesoConfidencial;

    public Psicopedagogo(String correoInstitucional) {
        super(correoInstitucional);
        this.accesoConfidencial = true;
    }

    public String getSectorPsicopedagogia() {
        return sectorPsicopedagogia;
    }

    public void setSectorPsicopedagogia(String sectorPsicopedagogia) {
        this.sectorPsicopedagogia = sectorPsicopedagogia;
    }

    // Constructor completo
    public Psicopedagogo(String correoInstitucional, String nombre, String apellido, String fechaNacimiento,
                         String cedulaId, String ITR, Rol rol, String direccion, String sectorPsicopedagogia,
                         boolean accesoConfidencial) {
        super(correoInstitucional, nombre, apellido, fechaNacimiento, cedulaId, rol, direccion);
        this.sectorPsicopedagogia = sectorPsicopedagogia;
        this.accesoConfidencial = accesoConfidencial;

    }

    public boolean isAccesoConfidencial() {
        return accesoConfidencial;
    }

    public void setAccesoConfidencial(boolean accesoConfidencial) {
        this.accesoConfidencial = accesoConfidencial;
    }

    // Metodo para crear una instancia de seguimiento
    public InstanciaSeguimiento crearInstanciaSeguimiento(String titulo, String fechaString, String horaString,
                                                          String tipo, boolean confidencial,
                                                          Estudiante estudiante, String comentarios,
                                                          String campoConfidencial, boolean motivada) {
        return new InstanciaSeguimiento(titulo, fechaString, horaString, tipo, confidencial,
                estudiante, this, comentarios, campoConfidencial, motivada);
    }

    // Metodo para registrar un comentario
    public Comentario registrarComentario(String texto, boolean confidencial) {
        return new Comentario(this, texto, confidencial);
    }

    // Metodo para clasificar estudiante por prioridad
    public void clasificarEstudiante(Estudiante estudiante, String prioridad) {
        estudiante.setPrioridadSeguimiento(prioridad);
    }

    // Metodo toString sobrescrito
    @Override
    public String toString() {
        return "Psicopedagogo: " + getNombre() + " " + getApellido() +
                " | CI: " + getCedulaIdentidad() + " | Email: " + getCorreoInstitucional();    }
}