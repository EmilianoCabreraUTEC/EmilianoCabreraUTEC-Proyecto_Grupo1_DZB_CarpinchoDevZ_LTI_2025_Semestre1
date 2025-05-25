package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Recordatorio {
    private String titulo;
    private String tipo;
    private LocalDate fecha;
    private LocalTime hora;
    private String frecuencia; //puede ser única, diaria, semanal, mensual


    //constructor, fecha y hora se reciben como string y se parsean
    //esto momentaneamente para validar y testear en limpio creaciones de las instancias
    // una vez que tengamos todo acomodado podemos hacer que se reciba en el formato nativo localdate o localtime para facilitar el codigo

    public Recordatorio(String titulo, String tipo, String fechaString, String horaString, String frecuencia) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.fecha = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.hora = LocalTime.parse(horaString, DateTimeFormatter.ofPattern("HH:mm"));
        this.frecuencia = frecuencia;
    }

    private String generarIdUnico() {
        return UUID.randomUUID().toString();
    }
    // Por ahora un par de getters/setters sencillos, se entiende que mas adelante modificaremos y completaremos el codigo segun necesidades

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setFecha(String nuevaFechaString) {
        this.fecha = LocalDate.parse(nuevaFechaString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String toString() {
        return "Recordatorio{" +
                "titulo='" + titulo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", frecuencia='" + frecuencia + '\'' +
                '}';
    }
}

/*
ejemplo de creación de un recordatorio:
Recordatorio r = new Recordatorio("Reunión", "Académico", "05-10-2025", "14:30", "Única");
fecha recibe dia-mes-año , esta formateado con datetimeformatter a ddMMyyyy
 */

