package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

    public class InstanciaSeguimiento {
        private String id; //código identificador único
        private String titulo;
        private LocalDate fecha;
        private LocalTime hora;
        private String tipo;        // puede ser: reunión, llamado, coordinación.
        private boolean confidencial;
        private Estudiante estudiante;  //falta crear esta subclase: Estudiante
        private Usuario creadoPor;
        private String comentarios;
        private String campoConfidencial;
        private boolean cancelada;


        // Constructor
        public InstanciaSeguimiento(String titulo, String fechaString, String horaString, String tipo, boolean confidencial,
                                    Estudiante estudiante, Usuario creadoPor, String comentarios, String campoConfidencial) {
            this.id = generarIdUnico();
            this.titulo = titulo;
            this.fecha = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            this.hora = LocalTime.parse(horaString, DateTimeFormatter.ofPattern("HH:mm"));
            this.tipo = tipo;
            this.confidencial = confidencial;
            this.estudiante = estudiante;
            this.creadoPor = creadoPor;
            this.comentarios = comentarios;
            this.campoConfidencial = campoConfidencial;
            this.cancelada = false;
        }

        public InstanciaSeguimiento(String titulo, LocalDate fecha, LocalTime hora, String tipo, boolean confidencial, Estudiante estudiante, Usuario creadoPor, String comentarios, String campoConfidencial) {
        }

        // Métodos
        private String generarIdUnico() {
            return UUID.randomUUID().toString(); //no se como se arma el metodo para que sean con orden secuencial
        }
        public InstanciaSeguimiento clonar() {
            return new InstanciaSeguimiento(
                    this.titulo + " (copia)",
                    this.fecha,
                    this.hora,
                    this.tipo,
                    this.confidencial,
                    this.estudiante,
                    this.creadoPor,
                    this.comentarios,
                    this.campoConfidencial
            );
    }
}
