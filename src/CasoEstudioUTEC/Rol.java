package CasoEstudioUTEC;

import java.util.List;

public class Rol {
    private String nombre;
    private List<String> permisos;

    public Rol(String nombre, List<String> permisos) {
        this.nombre = nombre;
        this.permisos = permisos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<String> permisos) {
        this.permisos = permisos;
    }

    // Verificar si el rol tiene cierto permiso
    public boolean tienePermiso(String permiso) {
        return permisos != null && permisos.contains(permiso);
    }

    // metodos para trabajar en un futuro

    // permisos para un estudiante
    public static List<String> permisosEstudiante() {
            return List.of("ver_perfil", "editar_perfil");
        }
    // permisos para un psicopedagogo
    public static List<String> permisosPsicopedagogo() {
    return List.of(
            "ver_confidencial",
            "crear_instancia",
            "editar_comentarios",
            "crear_recordatorio",
            "consultar_historial",
            "generar_informes"
    );
}
    // prmisos para un administrador
    public static List<String> permisosAdministrador() {
        return List.of(
                "crear_usuario",
                "desactivar_usuario",
                "asignar_roles",
                "ver_todos_los_datos",
                "gestionar_permisos"
        );
    }

    @Override
    public String toString() {
        return "Rol: " + nombre + ", Permisos: " + permisos;
    }
}

// EJEMPLO DE ROL
// Rol psicopedagogo = new Rol("Psicopedagogo", List.of("ver_confidencial", "crear_instancia", "editar_comentarios"));