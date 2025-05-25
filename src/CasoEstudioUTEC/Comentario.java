package CasoEstudioUTEC;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comentario {

    private Usuario autor;
    private String texto;
    private LocalDateTime fechaCreacion;
    private boolean confidencial;

    public Comentario(Usuario autor, String texto, boolean confidencial) {
        this.autor = autor;
        this.texto = texto;
        this.fechaCreacion = LocalDateTime.now();
        this.confidencial = confidencial;
    }

    // Getters
    public Usuario getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public boolean isConfidencial() {
        return confidencial;
    }

    // Setters (solo si necesitás modificar el contenido)
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setConfidencial(boolean confidencial) {
        this.confidencial = confidencial;
    }

    @Override
    public String toString() {
        String visibilidad = "";
        if (confidencial) {
            visibilidad = " (Confidencial)";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return "Comentario" + "\n" +
                "Autor: " + autor.getNombre() + " " + autor.getApellido() + "\n" +
                "Fecha: " + fechaCreacion.format(formatter) + "\n" +
                "Texto: " + texto;
    }
}

