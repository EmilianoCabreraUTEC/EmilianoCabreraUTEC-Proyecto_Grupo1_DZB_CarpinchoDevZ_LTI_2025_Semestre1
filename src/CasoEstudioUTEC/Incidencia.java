package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/*
RF05: Registro de Incidencias
Las incidencias permiten documentar situaciones relevantes que no constituyen instancias de seguimiento,
pero que requieren ser registradas para análisis o intervención futura.
RF05.1: El sistema debe permitir registrar incidencias, indicando lugar, personas involucradas y quién la registró.
*/

public class Incidencia {
    private String id;
    private String lugar;
    private LocalDate fecha;
    private LocalTime hora;
    private List<Usuario> personasInvolucradas;
    private Usuario registradaPor;
    private String descripcion;

    public Incidencia(String lugar, String fechaString, String horaString,
                      List<Usuario> personasInvolucradas, Usuario registradaPor, String descripcion) {

        DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

        this.id = generarIdUnico();
        this.lugar = Objects.requireNonNull(lugar, "El lugar no puede ser null");
        this.fecha = LocalDate.parse(Objects.requireNonNull(fechaString, "La fecha no puede ser null"), fechaFormatter);
        this.hora = LocalTime.parse(Objects.requireNonNull(horaString, "La hora no puede ser null"), horaFormatter);
        this.personasInvolucradas = Objects.requireNonNull(personasInvolucradas, "La lista de personas involucradas no puede ser null");
        this.registradaPor = Objects.requireNonNull(registradaPor, "El usuario que registró la incidencia no puede ser null");
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción no puede ser null");
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getLugar() {
        return lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public List<Usuario> getPersonasInvolucradas() {
        return personasInvolucradas;
    }

    public Usuario getRegistradaPor() {
        return registradaPor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setPersonasInvolucradas(List<Usuario> personasInvolucradas) {
        this.personasInvolucradas = personasInvolucradas;
    }

    public void setRegistradaPor(Usuario registradaPor) {
        this.registradaPor = registradaPor;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método auxiliar
    private String generarIdUnico() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return "Incidencia ID: " + id + "\n"
                + "Lugar: " + lugar + "\n"
                + "Fecha: " + fecha.format(fechaFormatter) + "\n"
                + "Hora: " + hora.format(horaFormatter) + "\n"
                + "Registrada por: " + registradaPor.getNombre() + " " + registradaPor.getApellido() + "\n"
                + "Cantidad de personas involucradas: " + personasInvolucradas.size() + "\n"
                + "Descripción: " + descripcion;
    }
}
