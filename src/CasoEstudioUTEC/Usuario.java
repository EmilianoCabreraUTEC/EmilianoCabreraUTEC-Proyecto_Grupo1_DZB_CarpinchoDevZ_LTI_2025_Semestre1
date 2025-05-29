package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usuario {
    private String nombre;
    private String apellido;
    private String contrasenia;
    private String correoInstitucional;//es el correo facilitado por la universidad, por ejemplo nombre.apellido@utec.edu.uy
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
    private int edad;
    private String cedulaIdentidad;
    private String ITR;//ITR significa Instituto Tecnologico Regional, y refiere a la sede de la UTEC a la cual pertenece el usuario, ya sea como estudiante o como funcionariolos estudiantes solo pueden tener un ITR, no se los demas funcionarios
    private String rol;//ej: "administrador", "estudiante", "psicopedagogo", "area legal", "otro funcionario"
    private boolean permisoIngresarModificarYEliminarUsuarios;
    private boolean permisoCrearModificarVisualizarYEliminarInstancias;
    private boolean permisoCrearEliminarYModificarIncidencias;
    private boolean permisoCrearEliminarYModificarReportes;
    private boolean permisoCrearEliminarYModificarRecordatorios;
    private boolean permisoVisualizarDatosSensibles;
    //no se me ocurren ningun permiso mas, si pueden ayudarme con alguno que se me pase diganme;
    //¿Cómo funiconan los permisos?
    //-Cada usuario tiene acceso a determinados permisos, por ejemplo:
    //--Administrador: todos los permisos
    //--Psicopedagogo: todos menos los de usuario
    //--Otro funcionario: solo pueden acceder a la informacion no confidencial
    //---Consultar la letra de caso de estudio para mas informacion acerca de los roles y permisos
    //-Si un usuario tiene un permiso este es "true", de caso contrario este es "false"
    //-La asignacion de roles debe hacerse desde el constuctor de cada clase

    //construcor para añadir un usuario solo con el correo, la contraseña se genera sola y se envia al correo
    public Usuario(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
        this.contrasenia = crearContrasenia();
        this.nombre=extraerNombre(correoInstitucional);//saca el nombre directamente desde el correo
        this.apellido=extraerApellido(correoInstitucional);//lo mismo
    }
    public Usuario(String correoInstitucional, String nombre, String apellido, String fechaNacimiento, String cedulaId, String rol, String ITR, String direccion) {
        this.correoInstitucional = correoInstitucional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = crearContrasenia();
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.edad=calcularEdad(this.fechaNacimiento);
        this.cedulaIdentidad=cedulaId;
        this.rol=rol;
        this.ITR=ITR;
        this.direccion=direccion;
    }
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
    private String extraerNombre(String correo) {
        String nombre="";
        nombre=correo.substring(0,correo.indexOf(".")).toUpperCase();//quita el ".apellido@dominio"
        return nombre;
    }
    private String extraerApellido(String correo) {
        String apellido="";
        apellido=correo.substring(correo.indexOf(".")+1,correo.indexOf("@")).toUpperCase();//quita el nombre y el "@utec.edu.uy" del correo
        return apellido;
    }
    private int calcularEdad(LocalDate fechaNacimiento) {
        int edad=0;
        LocalDate fechaActual=LocalDate.now();
        edad=fechaActual.getYear() - fechaNacimiento.getYear();
        return edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = Integer.parseInt(edad);
    }
    public String getCedulaIdentidad() {
        return cedulaIdentidad;
    }
    public void setCedulaIdentidad(String cedulaIdentidad) {
        this.cedulaIdentidad = cedulaIdentidad;
    }
    public String getITR() {
        return ITR;
    }
    public void setITR(String ITR) {
        this.ITR = ITR;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getDireccion() {
        return direccion;
    }
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
}
