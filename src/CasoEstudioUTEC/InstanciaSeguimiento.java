package CasoEstudioUTEC;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID; //

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
        private boolean motivadaPorEstudiante;


        // Constructor
        public InstanciaSeguimiento(String titulo, String fechaString, String horaString, String tipo, boolean confidencial,
                                    Estudiante estudiante, Usuario creadoPor, String comentarios, String campoConfidencial, boolean motivada) {
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
            this.motivadaPorEstudiante = motivadaPorEstudiante;
        }
        //Getters y setters

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getId() {
            return id;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public LocalTime getHora() {
            return hora;
        }

        public void setHora(LocalTime hora) {
            this.hora = hora;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public boolean isConfidencial() {
            return confidencial;
        }

        public void setConfidencial(boolean confidencial) {
            this.confidencial = confidencial;
        }

        public Usuario getCreadoPor() {
            return creadoPor;
        }

        public String getComentarios() {
            return comentarios;
        }

        public void setComentarios(String comentarios) {
            this.comentarios = comentarios;
        }

        public String getCampoConfidencial() {
            return campoConfidencial;
        }

        public void setCampoConfidencial(String campoConfidencial) {
            this.campoConfidencial = campoConfidencial;
        }

        public boolean isCancelada() {
            return cancelada;
        }

        public void setCancelada(boolean cancelada) {
            this.cancelada = cancelada;
        }
        public boolean isMotivadaPorEstudiante() {
            return motivadaPorEstudiante;
        }

        public void setMotivadaPorEstudiante(boolean motivadaPorEstudiante) {
            this.motivadaPorEstudiante = motivadaPorEstudiante;
        }

        // Métodos
        private String generarIdUnico() {
            return UUID.randomUUID().toString(); //para que genere un id único
        }

        @Override
        public String toString() {
            return "Instancia " +
                    "ID= " + id + '\'' +
                    ", Titulo='" + titulo + '\'' +
                    ", Fecha= " + fecha +
                    ", Hora= " + hora +
                    ", Tipo= " + tipo + '\'' +
                    ", Confidencial= " + confidencial +
                    ", Estudiante= " + estudiante +
                    ", Creado por= " + creadoPor +
                    ", Comentarios='" + comentarios + '\'' +
                    ", Información confidencial= " + campoConfidencial + '\'' +
                    ", Cancelada=" + cancelada +
                    ", Motivada por estudiante= " + motivadaPorEstudiante +
                    '}';
        }

        public InstanciaSeguimiento clonar() {
            return new InstanciaSeguimiento(
                    this.titulo + " (copia)",
                    this.fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                    this.hora.format(DateTimeFormatter.ofPattern("HH:mm")),
                    this.tipo,
                    this.confidencial,
                    this.estudiante,
                    this.creadoPor,
                    this.comentarios,
                    this.campoConfidencial,
                    this.motivadaPorEstudiante,
            );

    }
}
