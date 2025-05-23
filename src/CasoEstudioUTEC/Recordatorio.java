package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Recordatorio {
    private String titulo;
    private String tipo;
    private LocalDate fecha;
    private LocalTime hora;
    private String frecuencia; //puede ser única, diaria, semanal, mensual


    //constructor, fecha y hora se reciben como string y se parsean
    public Recordatorio(String titulo, String tipo, String fechaString, String horaString, String frecuencia) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.fecha = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.hora = LocalTime.parse(horaString, DateTimeFormatter.ofPattern("HH:mm"));
        this.frecuencia = frecuencia;
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

// ejemplo de creación de un recordatorio,
//Recordatorio r = new Recordatorio("Reunión", "Académico", "2025-05-10", "14:30", "Única");

