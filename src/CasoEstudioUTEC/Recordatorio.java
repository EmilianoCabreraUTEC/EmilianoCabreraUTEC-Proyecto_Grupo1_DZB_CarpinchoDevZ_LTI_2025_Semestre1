package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

public class Recordatorio {
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");

    private String id;
    private String titulo;
    private String tipo;
    private LocalDate fecha;
    private LocalTime hora;
    private String frecuencia; // única, diaria, semanal, mensual
    private Usuario destinatario; // relación agregada

    // Constructor con validaciones y relación con Usuario
    public Recordatorio(String titulo, String tipo, String fechaString, String horaString,
                        String frecuencia, Usuario destinatario) {

        this.id = generarIdUnico();
        this.titulo = Objects.requireNonNull(titulo, "El título no puede ser null");
        this.tipo = Objects.requireNonNull(tipo, "El tipo no puede ser null");
        this.fecha = LocalDate.parse(Objects.requireNonNull(fechaString, "La fecha no puede ser null"), FORMATO_FECHA);
        this.hora = LocalTime.parse(Objects.requireNonNull(horaString, "La hora no puede ser null"), FORMATO_HORA);
        this.frecuencia = Objects.requireNonNull(frecuencia, "La frecuencia no puede ser null");
        this.destinatario = Objects.requireNonNull(destinatario, "El destinatario no puede ser null");
    }

    private String generarIdUnico() {
        return UUID.randomUUID().toString();
    }

    // Getters
    public String getId() { return id; }

    public String getTitulo() { return titulo; }

    public String getTipo() { return tipo; }

    public LocalDate getFecha() { return fecha; }

    public LocalTime getHora() { return hora; }

    public String getFrecuencia() { return frecuencia; }

    public Usuario getDestinatario() { return destinatario; }

    // Setters
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        }
    }

    public void setTipo(String tipo) {
        if (tipo != null && !tipo.isEmpty()) {
            this.tipo = tipo;
        }
    }

    public void setFrecuencia(String frecuencia) {
        if (frecuencia != null && !frecuencia.isEmpty()) {
            this.frecuencia = frecuencia;
        }
    }

    public void setFecha(String nuevaFechaString) {
        this.fecha = LocalDate.parse(nuevaFechaString, FORMATO_FECHA);
    }

    public void setHora(String nuevaHoraString) {
        this.hora = LocalTime.parse(nuevaHoraString, FORMATO_HORA);
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Recordatorio{" +
                "ID='" + id + '\'' +
                ", Título='" + titulo + '\'' +
                ", Tipo='" + tipo + '\'' +
                ", Fecha=" + fecha +
                ", Hora=" + hora +
                ", Frecuencia='" + frecuencia + '\'' +
                ", Destinatario=" + destinatario.getNombre() + " " + destinatario.getApellido() +
                '}';
    }
}
