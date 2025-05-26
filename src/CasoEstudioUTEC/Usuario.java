package CasoEstudioUTEC;

import java.time.LocalDate;
import java.util.UUID;

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

    public Usuario(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
        this.contrasenia = crearContrasenia();
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
    public String getEdad() {
        return edad + "";
    }

}
