package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class InstanciaSeguimiento {

    private String id;         //código identificador único
    private String titulo;
    private LocalDate fecha;
    private LocalTime hora;
    private String tipo;        // puede ser: reunión, llamado, coordinación.
    private boolean confidencial;
       //falta crear esta subclase: Estudiante (private Estudiante estudiante)
    private Usuario creadoPor;
    private String comentarios;
    private String campoConfidencial;
    private boolean cancelada;
}
