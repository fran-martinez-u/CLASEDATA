public class Casillero { 

    // Atributos de la clase Casillero, representan las características de cada compartimento. 

    private int numero;          // Número único que identifica el casillero (ej. #1, #2, etc.). 

    private String tamano;       // Tamaño del casillero (ej. "Pequeño", "Mediano", "Grande"). 

    private boolean ocupado;     // Estado del casillero: 'true' si tiene un paquete, 'false' si está vacío. 

    private Paquete paqueteAsignado; // Referencia al objeto Paquete que está dentro del casillero. Es 'null' si está vacío. 

 

    /** 

     * Constructor de la clase Casillero. 

     * Inicializa un nuevo casillero con un número y un tamaño definidos. 

     * Por defecto, un casillero recién creado no está ocupado y no tiene un paquete asignado. 

     */ 

    public Casillero(int numero, String tamano) { 

        this.numero = numero; 

        this.tamano = tamano; 

        this.ocupado = false; 

        this.paqueteAsignado = null; 

    } 

 

    // --- Métodos de acceso (Getters) --- 

    // Permiten que otras clases obtengan información del casillero de manera controlada. 

 

    public int getNumero() { 

        return numero; 

    } 

 

    public boolean estaOcupado() { 

        return ocupado; 

    } 

 

    public Paquete getPaqueteAsignado() { 

        return paqueteAsignado; 

    } 

     

    public String getTamano() { 

        return tamano; 

    } 
    /** 

     * Asigna un paquete a este casillero. 

     * Solo se asigna si el casillero está actualmente desocupado. 

     */ 

    public void asignarPaquete(Paquete paquete) { 

        if (!this.ocupado) { 

            this.paqueteAsignado = paquete; 

            this.ocupado = true; 

        } 

    } 

 