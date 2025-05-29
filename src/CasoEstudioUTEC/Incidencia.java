package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        this.lugar = lugar;
        this.fecha = LocalDate.parse(fechaString, fechaFormatter);
        this.hora = LocalTime.parse(horaString, horaFormatter);
        this.personasInvolucradas = personasInvolucradas;
        this.registradaPor = registradaPor;
        this.descripcion = descripcion;
    }


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
                + "Registrada por: " + registradaPor.getNombre() + " " + registradaPor.getApellido() + "\n" //aun faltan crear esos metodos en Usuario
                + "Cantidad de personas involucradas: " + personasInvolucradas.size() + "\n"
                + "Descripción: " + descripcion;
    }
}
