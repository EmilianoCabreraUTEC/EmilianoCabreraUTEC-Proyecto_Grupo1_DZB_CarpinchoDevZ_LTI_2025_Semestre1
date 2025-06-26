package CasoEstudioUTEC;

import java.util.List;
import java.util.Objects;

public class Rol {
    private String nombre;
    private List<String> permisos;

    public Rol(String nombre, List<String> permisos) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre del rol no puede ser null");
        this.permisos = Objects.requireNonNull(permisos, "Los permisos no pueden ser null");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public List<String> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<String> permisos) {
        if (permisos != null) {
            this.permisos = permisos;
        }
    }

    // Verifica si el rol tiene un permiso específico
    public boolean tienePermiso(String permiso) {
        return permisos != null && permisos.contains(permiso);
    }

    // Permisos predefinidos (reutilizables)
    public static List<String> permisosEstudiante() {
        return List.of("ver_perfil", "editar_perfil");
    }

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

    public static List<String> permisosAdministrador() {
        return List.of(
                "crear_usuario",
                "desactivar_usuario",
                "asignar_roles",
                "ver_todos_los_datos",
                "gestionar_permisos"
        );
    }

    // Fábrica de roles comunes
    public static Rol crearRolEstudiante() {
        return new Rol("Estudiante", permisosEstudiante());
    }

    public static Rol crearRolPsicopedagogo() {
        return new Rol("Psicopedagogo", permisosPsicopedagogo());
    }

    public static Rol crearRolAdministrador() {
        return new Rol("Administrador", permisosAdministrador());
    }

    @Override
    public String toString() {
        return "🔐 Rol: " + nombre + "\n" +
                "Permisos: " + String.join(", ", permisos);
    }
}
