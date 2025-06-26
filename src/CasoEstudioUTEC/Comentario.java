package CasoEstudioUTEC;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Comentario {

    private Usuario autor;
    private String texto;
    private LocalDateTime fechaCreacion;
    private boolean confidencial;
    private InstanciaSeguimiento instanciaRelacionado;

    // Constructor con validaciones
    public Comentario(Usuario autor, String texto, boolean confidencial) {
        this.autor = Objects.requireNonNull(autor, "El autor no puede ser null");
        this.texto = texto;
        this.fechaCreacion = LocalDateTime.now();
        this.confidencial = confidencial;
        this.instanciaRelacionado = Objects.requireNonNull(instanciaRelacionado, "La instancia relacionada no puede ser null");
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

    public InstanciaSeguimiento getInstanciaRelacionado() {
        return instanciaRelacionado;
    }

    // Setters
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setConfidencial(boolean confidencial) {
        this.confidencial = confidencial;
    }

    public void setInstanciaRelacionado(InstanciaSeguimiento instanciaRelacionado) {
        this.instanciaRelacionado = instanciaRelacionado;
    }

    @Override
    public String toString() {
        String visibilidad = confidencial ? " (Confidencial)" : "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return "Comentario" + visibilidad + "\n" +
                "Autor: " + autor.getNombre() + " " + autor.getApellido() + "\n" +
                "Fecha: " + fechaCreacion.format(formatter) + "\n" +
                "Relacionado a instancia: " + instanciaRelacionado.getId() + "\n" +
                "Texto: " + texto;
    }
}
