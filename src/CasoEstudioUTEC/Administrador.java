package CasoEstudioUTEC;

import java.util.Objects;

/*
Requerimientos asociados a permisos de admin
RF06.1: El sistema debe permitir la recuperación de contraseña y que un administrador pueda resetearla.
RF06.2: El sistema debe restringir el acceso de lectura y edición de los datos confidenciales
*/
public class Administrador extends Usuario {
    private String sectorAdministrativo; // puede ser soporte técnico
    private boolean accesoConfidencial;  // true si puede ver/editar datos sensibles

    // Constructor básico usando solo el correo
    public Administrador(String correoInstitucional) {
        super(correoInstitucional);
        this.accesoConfidencial = true; // por defecto los administradores tienen acceso
    }

    // Constructor completo con validación de null en campos obligatorios
    public Administrador(String correoInstitucional, String nombre, String apellido, String fechaNacimiento,
                         String cedulaId, Rol rol, String direccion, String sectorAdministrativo,
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

    // Método para resetear contraseña de un usuario con validación de null
    public void resetearContrasenia(Usuario usuario, String nuevaContrasenia) {
        if (usuario == null || nuevaContrasenia == null || nuevaContrasenia.isEmpty()) {
            System.out.println("No se puede resetear la contraseña: datos inválidos.");
            return;
        }
        usuario.cambiarContrasenia(nuevaContrasenia);
        System.out.println("Contraseña reseteada para el usuario: " + usuario.getCorreoInstitucional());
    }

    // Lógica para controlar acceso a datos confidenciales (RF06.2)
    public void accederADatosConfidenciales() {
        if (accesoConfidencial) {
            System.out.println("Accediendo a datos confidenciales...");
            // logica a implementar - manejo de acceso por roles
        } else {
            System.out.println("Acceso denegado. No tienes permisos para ver datos confidenciales.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nAdministrador{" +
                "Sector Administrativo='" + sectorAdministrativo + '\'' +
                ", Acceso Confidencial=" + accesoConfidencial +
                '}';
    }
}
