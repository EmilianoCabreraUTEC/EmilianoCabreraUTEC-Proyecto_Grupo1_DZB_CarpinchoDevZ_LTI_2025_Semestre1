package CasoEstudioUTEC;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Reporte {
    private String id;
    private Estudiante estudiante;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<InstanciaSeguimiento> instancias;
    private List<Recordatorio> recordatorios;

    // Constructor
    public Reporte(Estudiante estudiante, LocalDate fechaInicio, LocalDate fechaFin,
                   List<InstanciaSeguimiento> instancias, List<Recordatorio> recordatorios) {
        this.id = generarIdUnico();
        this.estudiante = estudiante;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.instancias = instancias;
        this.recordatorios = recordatorios;
    }

    private String generarIdUnico() {
        return UUID.randomUUID().toString();
    }

    // Getters
    public String getId() {
        return id;
    }

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

    // Representación en texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Reporte para: ").append(estudiante.getNombre()).append(" ").append(estudiante.getApellido()).append("\n");
        sb.append(" Rango: ").append(fechaInicio).append(" al ").append(fechaFin).append("\n\n");

        sb.append(" Instancias de seguimiento:\n");
        if (instancias.isEmpty()) {
            sb.append("   - No hay instancias registradas.\n");
        } else {
            for (InstanciaSeguimiento i : instancias) {
                sb.append("   • ").append(i.getFecha()).append(" ").append(i.getHora())
                        .append(" - ").append(i.getTitulo()).append(" (").append(i.getTipo()).append(")\n");
            }
        }

        sb.append("\n Recordatorios:\n");
        if (recordatorios.isEmpty()) {
            sb.append("   - No hay recordatorios registrados.\n");
        } else {
            for (Recordatorio r : recordatorios) {
                sb.append("   • ").append(r.getFecha()).append(" ").append(r.getHora())
                        .append(" - ").append(r.getTitulo()).append(" [").append(r.getFrecuencia()).append("]\n");
            }
        }

        return sb.toString();
    }

    // Placeholder para exportar (sólo como idea para futuro ya que se plantea en los requerimentos pero tiene logica compleja)
    public void exportarPDF() {
        System.out.println("Exportando reporte a PDF... (funcionalidad pendiente)");
    }

    public void exportarCSV() {
        System.out.println("Exportando reporte a CSV... (funcionalidad pendiente)");
    }

    public void exportarExcel() {
        System.out.println("Exportando reporte a Excel... (funcionalidad pendiente)");
    }
}
