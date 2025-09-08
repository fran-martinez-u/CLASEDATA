import java.util.Date;  

 

// La clase Paquete representa un paquete individual que será almacenado en un casillero. 

public class Paquete { 

    // Atributos privados para almacenar los datos del paquete. 

    private String id; // Identificador único del paquete. 

    private String destinatario; // Nombre de la persona a la que va dirigido. 

    private String fechaIngreso; // Fecha y hora en que el paquete llegó al casillero. 

 

    // Constructor de la clase Paquete. 	 

    public Paquete(String id, String destinatario) { 

        this.id = id; 

        this.destinatario = destinatario; 

        // Asigna automáticamente la fecha y hora de creación del objeto. 

        this.fechaIngreso = new Date().toString();  

    } 

 

    // Métodos "get" para acceder a los atributos del paquete. 

 

    public String getId() { 

        return id; 

    } 

 

    public String getDestinatario() { 

        return destinatario; 

    } 

 

    public String getFechaIngreso() { 

        return fechaIngreso; 

    } 

 

    // Al usar @Override, le decimos al compilador que estamos redefiniendo el método 

    // toString() de la clase padre (Object) para mostrar información útil. 

    @Override 

    public String toString() { 

        return "ID: " + id + ", Destinatario: " + destinatario + ", Fecha de Ingreso: " + fechaIngreso; 

    } 

} 
