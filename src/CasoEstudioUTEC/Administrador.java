package CasoEstudioUTEC;
/*Requerimientos asociados a permisos de admin
RF06.1: El sistema debe permitir la recuperación de contraseña y que un administrador pueda resetearla.
RF06.2: El sistema debe restringir el acceso de lectura y edición de los datos confidenciales
*/
public class Administrador extends Usuario {
    private String sectorAdministrativo; // puede ser soporte técnico
    private boolean accesoConfidencial; // true si puede ver/editar datos sensibles

    // Constructor básico usando solo el correo
    public Administrador(String correoInstitucional) {
        super(correoInstitucional);
        this.accesoConfidencial = true; // por defecto los administradores tienen acceso
    }

    // Constructor completo
    public Administrador(String correoInstitucional, String nombre, String apellido, String fechaNacimiento,
                         String cedulaId, String ITR, String rol, String direccion, String sectorAdministrativo,
                         boolean accesoConfidencial) {
        super(correoInstitucional, nombre, apellido, fechaNacimiento, cedulaId, ITR, rol, direccion);
        this.sectorAdministrativo = sectorAdministrativo;
        this.accesoConfidencial = accesoConfidencial;
    }

    // Getters y Setters
    public String getSectorAdministrativo() {
        return sectorAdministrativo;
    }

    public void setSectorAdministrativo(String sectorAdministrativo) {
        this.sectorAdministrativo = sectorAdministrativo;
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

    @Override
    public String toString() {
        return super.toString() + "\nAdministrador{" +
                "Sector Administrativo='" + sectorAdministrativo+ '\'' +
                ", Acceso Confidencial=" + accesoConfidencial +
                '}';
    }
}