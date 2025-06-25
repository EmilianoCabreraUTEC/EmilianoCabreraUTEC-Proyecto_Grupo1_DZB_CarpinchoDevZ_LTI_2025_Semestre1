package CasoEstudioUTEC;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estudiante extends Usuario {

    private String ITR;
    private String carrera;
    private int semestre;
    private String grupo;
    private String sistemaSalud;
    private String motivoSeguimiento;
    private String estadoSalud;
    private String tratamientoMedico;
    private String estado; // creado, en seguimiento, finalizado, eliminado
    private String prioridadSeguimiento; // bajo, medio, alto

    private List<Comentario> comentarios = new ArrayList<>();
    private List<InstanciaSeguimiento> instanciasSeguimiento = new ArrayList<>();

    // Constructor básico
    public Estudiante(String correoInstitucional) {
        super(correoInstitucional);
    }

    // Constructor completo con validaciones
    public Estudiante(String correoInstitucional, String nombre, String apellido, String fechaNacimiento, String cedulaId,
                      Rol rol, String direccion, String ITR, String carrera, int semestre, String grupo,
                      String sistemaSalud, String motivoSeguimiento, String estadoSalud, String tratamientoMedico,
                      String estado, String prioridadSeguimiento) {

        super(
                Objects.requireNonNull(correoInstitucional, "Correo no puede ser null"),
                Objects.requireNonNull(nombre, "Nombre no puede ser null"),
                Objects.requireNonNull(apellido, "Apellido no puede ser null"),
                Objects.requireNonNull(fechaNacimiento, "Fecha nacimiento no puede ser null"),
                Objects.requireNonNull(cedulaId, "Cédula no puede ser null"),
                Objects.requireNonNull(rol, "Rol no puede ser null"),
                direccion
        );
        this.ITR = ITR;
        this.carrera = carrera;
        this.semestre = semestre;
        this.grupo = grupo;
        this.sistemaSalud = sistemaSalud;
        this.motivoSeguimiento = motivoSeguimiento;
        this.estadoSalud = estadoSalud;
        this.tratamientoMedico = tratamientoMedico;
        this.estado = estado;
        this.prioridadSeguimiento = prioridadSeguimiento;
    }

    // Getters y Setters
    public String getITR() { return ITR; }
    public void setITR(String ITR) { this.ITR = ITR; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public int getSemestre() { return semestre; }
    public void setSemestre(int semestre) { this.semestre = semestre; }

    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }

    public String getSistemaSalud() { return sistemaSalud; }
    public void setSistemaSalud(String sistemaSalud) { this.sistemaSalud = sistemaSalud; }

    public String getMotivoSeguimiento() { return motivoSeguimiento; }
    public void setMotivoSeguimiento(String motivoSeguimiento) { this.motivoSeguimiento = motivoSeguimiento; }

    public String getEstadoSalud() { return estadoSalud; }
    public void setEstadoSalud(String estadoSalud) { this.estadoSalud = estadoSalud; }

    public String getTratamientoMedico() { return tratamientoMedico; }
    public void setTratamientoMedico(String tratamientoMedico) { this.tratamientoMedico = tratamientoMedico; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPrioridadSeguimiento() { return prioridadSeguimiento; }
    public void setPrioridadSeguimiento(String prioridadSeguimiento) { this.prioridadSeguimiento = prioridadSeguimiento; }

    // Relaciones
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void agregarComentario(Comentario comentario) {
        if (comentario != null) {
            comentarios.add(comentario);
        }
    }

    public List<InstanciaSeguimiento> getInstanciasSeguimiento() {
        return instanciasSeguimiento;
    }

    public void agregarInstanciaSeguimiento(InstanciaSeguimiento instancia) {
        if (instancia != null) {
            instanciasSeguimiento.add(instancia);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nEstudiante{" +
                "ITR='" + ITR + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                ", grupo='" + grupo + '\'' +
                ", sistemaSalud='" + sistemaSalud + '\'' +
                ", motivoSeguimiento='" + motivoSeguimiento + '\'' +
                ", estadoSalud='" + estadoSalud + '\'' +
                ", tratamientoMedico='" + tratamientoMedico + '\'' +
                ", estado='" + estado + '\'' +
                ", prioridad='" + prioridadSeguimiento + '\'' +
                ", comentarios=" + comentarios.size() +
                ", seguimientos=" + instanciasSeguimiento.size() +
                '}';
    }
}
