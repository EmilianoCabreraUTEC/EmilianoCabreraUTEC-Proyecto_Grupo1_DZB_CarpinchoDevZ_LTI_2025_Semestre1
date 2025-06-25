package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class InstanciaSeguimiento {
    private String id; // código identificador único
    private String titulo;
    private LocalDate fecha;
    private LocalTime hora;
    private String tipo; // reunión, llamado, coordinación
    private boolean confidencial;
    private Estudiante estudiante;
    private Usuario creadoPor;
    private String comentarios;
    private String campoConfidencial;
    private boolean cancelada;
    private boolean motivadaPorEstudiante;

    // Constructor con validaciones
    public InstanciaSeguimiento(String titulo, String fechaString, String horaString, String tipo, boolean confidencial,
                                Estudiante estudiante, Usuario creadoPor, String comentarios,
                                String campoConfidencial, boolean motivadaPorEstudiante) {

        this.id = generarIdUnico();
        this.titulo = Objects.requireNonNull(titulo, "El título no puede ser null");
        this.fecha = LocalDate.parse(Objects.requireNonNull(fechaString, "La fecha no puede ser null"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.hora = LocalTime.parse(Objects.requireNonNull(horaString, "La hora no puede ser null"),
                DateTimeFormatter.ofPattern("HH:mm"));
        this.tipo = Objects.requireNonNull(tipo, "El tipo no puede ser null");
        this.confidencial = confidencial;
        this.estudiante = Objects.requireNonNull(estudiante, "El estudiante no puede ser null");
        this.creadoPor = Objects.requireNonNull(creadoPor, "El creador no puede ser null");
        this.comentarios = comentarios;
        this.campoConfidencial = campoConfidencial;
        this.cancelada = false;
        this.motivadaPorEstudiante = motivadaPorEstudiante;
    }

    // Getters y Setters
    public String getId() { return id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isConfidencial() { return confidencial; }
    public void setConfidencial(boolean confidencial) { this.confidencial = confidencial; }

    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }

    public Usuario getCreadoPor() { return creadoPor; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public String getCampoConfidencial() { return campoConfidencial; }
    public void setCampoConfidencial(String campoConfidencial) { this.campoConfidencial = campoConfidencial; }

    public boolean isCancelada() { return cancelada; }
    public void setCancelada(boolean cancelada) { this.cancelada = cancelada; }

    public boolean isMotivadaPorEstudiante() { return motivadaPorEstudiante; }
    public void setMotivadaPorEstudiante(boolean motivadaPorEstudiante) { this.motivadaPorEstudiante = motivadaPorEstudiante; }

    // Generar nuevo ID único
    private String generarIdUnico() {
        return UUID.randomUUID().toString();
    }

    // Clonación (genera nuevo ID)
    public InstanciaSeguimiento clonar() {
        return new InstanciaSeguimiento(
                this.titulo + " (copia)",
                this.fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                this.hora.format(DateTimeFormatter.ofPattern("HH:mm")),
                this.tipo,
                this.confidencial,
                this.estudiante,
                this.creadoPor,
                this.comentarios,
                this.campoConfidencial,
                this.motivadaPorEstudiante
        );
    }

    @Override
    public String toString() {
        return "InstanciaSeguimiento{" +
                "ID='" + id + '\'' +
                ", Título='" + titulo + '\'' +
                ", Fecha=" + fecha +
                ", Hora=" + hora +
                ", Tipo='" + tipo + '\'' +
                ", Confidencial=" + confidencial +
                ", Estudiante=" + estudiante.getNombre() + " " + estudiante.getApellido() +
                ", Creado por=" + creadoPor.getNombre() + " " + creadoPor.getApellido() +
                ", Comentarios='" + comentarios + '\'' +
                ", Información Confidencial='" + campoConfidencial + '\'' +
                ", Cancelada=" + cancelada +
                ", MotivadaPorEstudiante=" + motivadaPorEstudiante +
                '}';
    }
}
