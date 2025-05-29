package CasoEstudioUTEC;

public class Testear {
    public static void main(String[] args) {
        Recordatorio r = new Recordatorio("Reunión", "Académico", "10-05-2025", "14:30", "Única");
        System.out.println(r);
        Usuario u=new Usuario("adriana.yoda@gmail.com","Adriana","Yoda","02-06-2000","55554589","Estudiante");
        System.out.println(u.getEdad());
    }
}


/*
Usar esta clase para testear creacion de instancias de las clases
si da problema otra clase pueden comentar localmente todo el codigo y correr solamente la instancia
*/