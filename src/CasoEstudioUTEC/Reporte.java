package CasoEstudioUTEC;
/*
Según los requerimientos:
-Generar un reporte por estudiante y rango de fechas.
-Incluir instancias de seguimiento y recordatorios.
-Poder representarse en varios formatos (PDF, Excel, CSV, visualización en pantalla).
 */

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Reporte {
    private Estudiante estudiante; //falta aun la subclase Estudiante, se asume que tendra metodos getNombre y getApellido
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<InstanciaSeguimiento> instancias;
    private List<Recordatorio> recordatorios;

public Reporte(Estudiante estudiante, LocalDate fechaInicio, LocalDate fechaFin,
               List<InstanciaSeguimiento> instancias, List<Recordatorio> recordatorios) {
    this.estudiante = estudiante;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
    this.instancias = instancias;
    this.recordatorios = recordatorios;
}
    private String generarIdUnico() {
        return UUID.randomUUID().toString();
    }
// De momento algunos getters sencillos, más adelante evaluaremos según los requerimentos el tema de generar pdf o csv

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public List<InstanciaSeguimiento> getInstancias() {
        return instancias;
    }

    public List<Recordatorio> getRecordatorios() {
        return recordatorios;
    }

    @Override
    public String toString() {
        return "Reporte para: " + estudiante.getNombre() + " " + estudiante.getApellido() +
                " del " + fechaInicio + " al " + fechaFin;

        /* falta agregar en la respuesta las instancias registradas de ese estudiante y los recordatorios,
        que deberian mostrarse en el reporte
        */

    }
}

