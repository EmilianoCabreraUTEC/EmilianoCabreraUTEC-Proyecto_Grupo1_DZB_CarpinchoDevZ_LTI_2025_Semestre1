package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Usuario {
    protected String nombre;
    protected String apellido;
    protected String nombreUsuario;//no confundir con nombre, este permite logear al sistema mientras que el otro no
    protected String contrasenia;
    protected String correoInstitucional;//es el correo facilitado por la universidad,formato esperado: nombre.apellido@(estudiante.)utec.edu.uy
    protected String telefono;//el usuario es libre de agregar uno DESPUES de haber sido registrado en el sistema
    protected String direccion;
    protected LocalDate fechaNacimiento;
    protected int edad;
    protected String cedulaIdentidad;
    protected Rol rol;

    //construcor para añadir un usuario solo con el correo, la contraseña se genera sola y se envia al correo
    public Usuario(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
        this.nombreUsuario = crearNombreDeUsuario();
        this.contrasenia = crearContrasenia();
        this.nombre=extraerNombre(correoInstitucional);//saca el nombre directamente desde el correo
        this.apellido=extraerApellido(correoInstitucional);//lo mismo, pero con el apellido
    }
    public Usuario(String correoInstitucional, String nombre, String apellido, String fechaNacimiento, String cedulaId, Rol rol, String direccion) {
        this.correoInstitucional = correoInstitucional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = crearNombreDeUsuario();
        this.contrasenia = crearContrasenia();//la contraseña se crea de forma automatica y debe enviarse por correo al usuario
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.edad=calcularEdad(this.fechaNacimiento);
        this.cedulaIdentidad=cedulaId;
        this.rol=rol;
        this.direccion=direccion;
    }

    //Metodos de la clase Usuario, diseñados para agilizar la creacion de usuarios

    //metodo que permite generar una contraseña relativamente segura de forma automatica
    //esta debe ser enviada al nuevo usuario por correo para que ingrese al sistema
    //se espera que este la cambie luego de esto para garantizar la seguridad
    private String crearContrasenia() {
        char[] caracteres = {'a', 'b', 'c', 'd', 'e', 'f', '?','!','=','&','%','g', 'h', 'i', 'j', 'k','1','2','3','4', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's','5','6','7','8','9','0'};
        StringBuilder contrasenia = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            //toma un caracter al azar y lo pone en la contraseña
            //cada una de ellas sera disitinta
            contrasenia.append(caracteres[(int) Math.ceil(Math.random()*(caracteres.length-1))]);
        }
        return contrasenia.toString();
    }
    //debido a que el formato del mail es "nombre.apellido@correo" se puede extraer tanto el
    // nombre como el apellido de este al remover el punto y lo que esta despues de la arroba
    private String extraerNombre(String correo) {
        String nombre="";
        nombre=correo.substring(0,correo.indexOf(".")).toUpperCase();//quita el ".apellido@dominio"
        return nombre;
    }
    private String extraerApellido(String correo) {
        return correo.substring(correo.indexOf(".")+1,correo.indexOf("@")).toUpperCase();//quita el nombre y el "@utec.edu.uy" del correo
    }
    //usa la logica de los metodos anteriores para generar un nombre de usuario con el
    //formato de "nombre.apellido"
    private String crearNombreDeUsuario() {
        return extraerNombre(correoInstitucional).toLowerCase()+"."+extraerApellido(correoInstitucional).toLowerCase();
    }
    //permite calcular la edad mediante la fecha de nacimiento
    //´por ahora esta pensado solo para la inicializacion de usuarios en el sistema y no como
    //una caracteristica continua (o sea que el sistema SIEMPRE calcule la edad cuando esta se requiera)
    private int calcularEdad(LocalDate fechaNacimiento) {
        int edad=0;
        LocalDate fechaActual=LocalDate.now();
        edad=fechaActual.getYear() - fechaNacimiento.getYear();
        return edad;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public int getEdad() {
        return edad;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public void setEdad(String edad) {
        this.edad = Integer.parseInt(edad);
    }
    public String getCedulaIdentidad() {
        return cedulaIdentidad;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public String getDireccion() { return direccion;}
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }
    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }

    // Metodo para cambiar la contraseña (como aclaramos que respete el formato anterior y que no pueda guardar la misma?)
    public boolean cambiarContrasenia(String nuevaContrasenia) {
        if (nuevaContrasenia == null || nuevaContrasenia.length() <12) {
            System.out.println("La contraseña debe tener al menos 12 caracteres.");
            return false;
        }
        this.contrasenia = nuevaContrasenia;
        return true;
    }

    //to string:
    @Override
    public String toString() {
        return "Usuario{" +
                "Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Nombre de Usuario='" + nombreUsuario + '\'' +
                ", Contraseña='" + contrasenia + '\'' +
                ", Correo Institucional='" + correoInstitucional + '\'' +
                ", Telefono='" + telefono + '\'' +
                ", Direccion='" + direccion + '\'' +
                ", Fecha Nacimiento=" + fechaNacimiento +
                ", Edad=" + edad +
                ", Cedula Identidad='" + cedulaIdentidad + '\'' +
                ", Rol='" + rol.toString() + '\'' +
                '}';
    }
}
