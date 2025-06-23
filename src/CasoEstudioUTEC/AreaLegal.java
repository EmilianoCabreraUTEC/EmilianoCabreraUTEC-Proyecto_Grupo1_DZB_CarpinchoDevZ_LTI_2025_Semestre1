package CasoEstudioUTEC;

import java.time.LocalDate;

    public class AreaLegal extends Usuario {
        private String areaLegal;
        private boolean accesoConfidencial;

        //Constructor
        public AreaLegal(String correoInstitucional, String nombre, String apellido, String fechaNacimiento, String cedulaId, Rol rol, String direccion, boolean accesoConfidencial, String areaLegal) {
            super(correoInstitucional, nombre, apellido, fechaNacimiento, cedulaId, rol, direccion);
            this.accesoConfidencial = accesoConfidencial;
            this.areaLegal = areaLegal;
        }
        //Getters y setters
        public String getAreaLegal() {
            return areaLegal;
        }

        public void setAreaLegal(String areaLegal) {
            this.areaLegal = areaLegal;
        }

        public boolean isAccesoConfidencial() {
            return accesoConfidencial;
        }

        public void setAccesoConfidencial(boolean accesoConfidencial) {
            this.accesoConfidencial = accesoConfidencial;
        }

        @Override
        public String toString() {
            return "Área Legal - " + getNombre() + " " + getApellido() +
                    " | C.I: " + getCedulaIdentidad() + " | Correo: " + getCorreoInstitucional();
        }
    }

