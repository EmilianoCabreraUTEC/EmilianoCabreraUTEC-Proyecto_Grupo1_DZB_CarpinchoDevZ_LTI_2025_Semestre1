package CasoEstudioUTEC;

public class Psicopedagogo extends Usuario {

    private String sectorPsicopedagogia;
    private boolean accesoConfidencial;

    public Psicopedagogo(String correoInstitucional) {
        super(correoInstitucional);
        this.accesoConfidencial = true;
    }

    // Constructor completo
    public Psicopedagogo(String correoInstitucional, String nombre, String apellido, String fechaNacimiento,
                         String cedulaId, String ITR, String rol, String direccion, String sectorPsicopedagogia,
                         boolean accesoConfidencial) {
        super(correoInstitucional, nombre, apellido, fechaNacimiento, cedulaId, rol, direccion);
        this.sectorPsicopedagogia = sectorPsicopedagogia;
        this.accesoConfidencial = accesoConfidencial;

    }
}