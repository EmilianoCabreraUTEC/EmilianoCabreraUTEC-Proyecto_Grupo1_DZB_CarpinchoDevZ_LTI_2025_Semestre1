package CasoEstudioUTEC;

import java.util.Objects;

public class AreaLegal extends Usuario {
    private String areaLegal;
    private boolean accesoConfidencial;

    // Constructor con validación de campos no nulos
    public AreaLegal(String correoInstitucional, String nombre, String apellido, String fechaNacimiento,
                     String cedulaId, Rol rol, String direccion, boolean accesoConfidencial, String areaLegal) {
        super(
                Objects.requireNonNull(correoInstitucional, "Correo no puede ser null"),
                Objects.requireNonNull(nombre, "Nombre no puede ser null"),
                Objects.requireNonNull(apellido, "Apellido no puede ser null"),
                Objects.requireNonNull(fechaNacimiento, "Fecha de nacimiento no puede ser null"),
                Objects.requireNonNull(cedulaId, "Cédula no puede ser null"),
                Objects.requireNonNull(rol, "Rol no puede ser null"),
                direccion
        );
        this.accesoConfidencial = accesoConfidencial;
        this.areaLegal = areaLegal;
    }

    // Getters y setters
    public String getAreaLegal() {
        return areaLegal;
    }

    public void setAreaLegal(String areaLegal) {
        this.areaLegal = areaLegal;
    }

    public boolean isAccesoConfidencial() {
        return accesoConfidencial;
    }

    public void setAccesoConfidencial(boolean accesoConfidencial) {
        this.accesoConfidencial = accesoConfidencial;
    }

    // Lógica relacionada al acceso confidencial (RF06.2)
    public void accederADocumentosLegalesConfidenciales() {
        if (accesoConfidencial) {
            System.out.println("Accediendo a documentos legales confidenciales...");
        } else {
            System.out.println("Acceso denegado. No tienes permisos para visualizar esta información.");
        }
    }

// metodo para corroborar si un documento es valido o no
    public boolean gestionarLegalidad(String documento) {
        if (documento != null && documento.contains("autorizado")) {
            System.out.println("El documento es legalmente válido.");
            return true;
        } else {
            System.out.println("El documento presenta irregularidades.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Área Legal - " + getNombre() + " " + getApellido() +
                " | C.I: " + getCedulaIdentidad() + " | Correo: " + getCorreoInstitucional();
    }
}
