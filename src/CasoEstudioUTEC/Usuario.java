package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected String nombreUsuario;
    protected String contrasenia;
    protected String correoInstitucional;
    protected String telefono;
    protected String direccion;
    protected LocalDate fechaNacimiento;
    protected int edad;
    protected String cedulaIdentidad;
    protected Rol rol;

    // Constructor básico con solo correo
    public Usuario(String correoInstitucional) {
        validarCorreo(correoInstitucional);
        this.correoInstitucional = correoInstitucional;
        this.nombreUsuario = crearNombreDeUsuario();
        this.contrasenia = crearContrasenia();
        this.nombre = extraerNombre(correoInstitucional);
        this.apellido = extraerApellido(correoInstitucional);
    }

    // Constructor completo
    public Usuario(String correoInstitucional, String nombre, String apellido, String fechaNacimiento,
                   String cedulaId, Rol rol, String direccion) {

        validarCorreo(correoInstitucional);
        this.correoInstitucional = correoInstitucional;
        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
        this.nombreUsuario = crearNombreDeUsuario();
        this.contrasenia = crearContrasenia();
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.edad = calcularEdad(this.fechaNacimiento);
        this.cedulaIdentidad = Objects.requireNonNull(cedulaId);
        this.rol = Objects.requireNonNull(rol);
        this.direccion = direccion;
    }

    // Validación de correo
    private void validarCorreo(String correo) {
        if (!correo.matches("^[a-z]+\\.[a-z]+@(estudiante\\.)?utec\\.edu\\.uy$")) {
            throw new IllegalArgumentException("El correo institucional no tiene el formato válido.");
        }
    }

    // Generación de credenciales
    private String crearContrasenia() {
        char[] caracteres = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                '0','1','2','3','4','5','6','7','8','9','!','?','=','&','%'};
        StringBuilder contrasenia = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            int pos = (int) (Math.random() * caracteres.length);
            contrasenia.append(caracteres[pos]);
        }
        return contrasenia.toString();
    }

    private String extraerNombre(String correo) {
        return correo.substring(0, correo.indexOf(".")).toUpperCase();
    }

    private String extraerApellido(String correo) {
        return correo.substring(correo.indexOf(".") + 1, correo.indexOf("@")).toUpperCase();
    }

    private String crearNombreDeUsuario() {
        return extraerNombre(correoInstitucional).toLowerCase() + "." +
                extraerApellido(correoInstitucional).toLowerCase();
    }

    // Cálculo de edad
    private int calcularEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // Cambiar contraseña
    public boolean cambiarContrasenia(String nuevaContrasenia) {
        if (nuevaContrasenia == null || nuevaContrasenia.length() < 12) {
            System.out.println("La contraseña debe tener al menos 12 caracteres.");
            return false;
        }
        if (nuevaContrasenia.equals(this.contrasenia)) {
            System.out.println("La nueva contraseña no puede ser igual a la anterior.");
            return false;
        }
        this.contrasenia = nuevaContrasenia;
        return true;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getCorreoInstitucional() { return correoInstitucional; }
    public void setCorreoInstitucional(String correoInstitucional) {
        validarCorreo(correoInstitucional);
        this.correoInstitucional = correoInstitucional;
    }

    public String getContrasenia() { return contrasenia; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.edad = calcularEdad(this.fechaNacimiento);
    }

    public String getCedulaId() { return cedulaIdentidad; }
    public void setCedulaId(String cedulaIdentidad) { this.cedulaIdentidad = cedulaIdentidad; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    @Override
    public String toString() {
        return "Usuario{" +
                "Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Usuario='" + nombreUsuario + '\'' +
                ", Correo='" + correoInstitucional + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", Dirección='" + direccion + '\'' +
                ", FechaNacimiento=" + fechaNacimiento +
                ", Edad=" + edad +
                ", Cédula='" + cedulaIdentidad + '\'' +
                ", Rol=" + rol.getNombre() +
                '}';
    }
}
