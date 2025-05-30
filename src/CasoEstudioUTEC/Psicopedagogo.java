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
                         String cedulaId, String ITR, String rol, String direccion, String sectorPsicopedagogia,
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
    // Metodo para resetear contraseña de un usuario
    public void resetearContrasenia(Usuario usuario, String nuevaContrasenia) {
        usuario.cambiarContrasenia(nuevaContrasenia);
        System.out.println("Contraseña reseteada para el usuario: " + usuario.getCorreoInstitucional());
    }
}