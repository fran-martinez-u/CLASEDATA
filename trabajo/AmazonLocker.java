import java.util.Scanner; 

 

// La clase principal del sistema de casilleros.  

public class AmazonLocker { 

 

    // Constantes para definir las dimensiones del sistema de casilleros. 

    private static final int FILAS = 5; 

    private static final int COLUMNAS = 10; 

     

    // La matriz que representa todos los casilleros disponibles. 

    private static Casillero[][] casilleros;  

     

    // Un contador para generar IDs de paquete únicos. 

    private static int contadorPaquetes = 0; 

     

    // Objeto Scanner para leer la entrada del usuario desde la consola. 

    private static Scanner scanner = new Scanner(System.in); 

 

    // El punto de entrada de la aplicación. 

    public static void main(String[] args) { 

        // Llama a los métodos para configurar el sistema y mostrar el menú. 

        inicializarCasilleros(); 

        mostrarMenu(); 

    } 

 

    /** 

     * Inicializa la matriz de casilleros con objetos Casillero. 

     * Asigna un número y un tamaño a cada casillero según la fila en la que se encuentra. 

     */ 

    private static void inicializarCasilleros() { 

        casilleros = new Casillero[FILAS][COLUMNAS]; 

        int numeroCasillero = 1;  

        for (int i = 0; i < FILAS; i++) { 

            for (int j = 0; j < COLUMNAS; j++) { 

                String tamano = "Pequeño"; 

                if (i == 2 || i == 3) { 

                    tamano = "Mediano"; 

                } else if (i == 4) { 

                    tamano = "Grande"; 

                } 

                casilleros[i][j] = new Casillero(numeroCasillero++, tamano); 

            } 

        } 

    } 

 

    /** 

     * Muestra el menú principal y gestiona la interacción con el usuario. 

     * El bucle 'do-while' mantiene el menú activo hasta que el usuario elija salir. 

     */ 

    private static void mostrarMenu() { 

        int opcion; 

        do { 

            System.out.println("\n--- Menú Principal ---"); 

            System.out.println("1. Registrar paquete en el casillero"); 

            System.out.println("2. Consultar casilleros disponibles"); 

            System.out.println("3. Información de un paquete"); 

            System.out.println("4. Desocupar un casillero"); 

            System.out.println("5. Salir de la aplicación"); 

            System.out.print("Seleccione una opción: "); 

 

            try { 

                // Lee la opción del usuario. 

                opcion = scanner.nextInt(); 

                scanner.nextLine(); // Consumir la nueva línea restante. 

 

                // Usa un 'switch' para ejecutar la acción correspondiente a la opción seleccionada. 

                switch (opcion) { 

                    case 1: 

                        registrarPaquete(); 

                        break; 

                    case 2: 

                        consultarCasillerosDisponibles(); 

                        break; 

                    case 3: 

                        informacionPaquete(); 

                        break; 

                    case 4: 

                        desocuparCasillero(); 

                        break; 

                    case 5: 

                        System.out.println("Cerrando la aplicación. ¡Hasta pronto!"); 

                        break; 

                    default: 

                        System.out.println("Opción no válida. Por favor, intente de nuevo."); 

                } 

            } catch (java.util.InputMismatchException e) { 

                // Maneja el error si el usuario ingresa algo que no es un número. 

                System.out.println("Entrada no válida. Por favor, ingrese un número."); 

                scanner.nextLine();  

                opcion = 0; // Se asigna 0 para continuar el bucle. 

            } 

        } while (opcion != 5); 

    } 

 

    /** 

     * Permite al usuario registrar un nuevo paquete en el primer casillero disponible. 

     * Crea un objeto Paquete y lo asigna a un casillero. 

     */ 

    private static void registrarPaquete() { 

        System.out.print("Ingrese el destinatario del paquete: "); 

        String destinatario = scanner.nextLine(); 

        String idPaquete = "P" + (++contadorPaquetes); 

 

        // Crea una nueva instancia de Paquete. 

        Paquete nuevoPaquete = new Paquete(idPaquete, destinatario); 

 

        // Busca una posición disponible en la matriz de casilleros. 

        int[] posicion = encontrarCasilleroDisponible(); 

        if (posicion != null) { 

            int fila = posicion[0]; 

            int columna = posicion[1]; 

            casilleros[fila][columna].asignarPaquete(nuevoPaquete); 

            int numeroCasillero = casilleros[fila][columna].getNumero(); 

            System.out.println("✅ Paquete " + idPaquete + " asignado al casillero #" + numeroCasillero + "."); 

        } else { 

            System.out.println("❌ No hay casilleros disponibles en este momento."); 

        } 

    } 

 

    /** 

     * Busca la primera posición de un casillero que no esté ocupado. 

     * Recorre la matriz y devuelve las coordenadas (fila, columna) si encuentra uno. 

     * @return Un array de enteros con las coordenadas [fila, columna] o 'null' si no hay casilleros libres. 

     */ 

    private static int[] encontrarCasilleroDisponible() { 

        for (int i = 0; i < FILAS; i++) { 

            for (int j = 0; j < COLUMNAS; j++) { 

                if (!casilleros[i][j].estaOcupado()) { 

                    return new int[]{i, j};  

                } 

            } 

        } 

        return null; 

    } 

 

    /** 

     * Muestra una lista de todos los casilleros que están actualmente vacíos. 

     */ 

    private static void consultarCasillerosDisponibles() { 

        System.out.println("\n--- Casilleros Disponibles ---"); 

        boolean hayDisponibles = false; 

        for (int i = 0; i < FILAS; i++) { 

            for (int j = 0; j < COLUMNAS; j++) { 

                if (!casilleros[i][j].estaOcupado()) { 

                    System.out.println("Casillero #" + casilleros[i][j].getNumero() + " (" + casilleros[i][j].getTamano() + ")"); 

                    hayDisponibles = true; 

                } 

            } 

        } 

        if (!hayDisponibles) { 

            System.out.println("Actualmente no hay casilleros disponibles."); 

        } 

    } 

 

    /** 

     * Permite al usuario consultar el estado y la información de un casillero específico. 

     * Si el casillero está ocupado, muestra los detalles del paquete. 

     */ 

    private static void informacionPaquete() { 

        System.out.print("Ingrese el número del casillero a consultar: "); 

        try { 

            int numeroCasillero = scanner.nextInt(); 

            scanner.nextLine(); 

 

            boolean encontrado = false; 

            for (int i = 0; i < FILAS; i++) { 

                for (int j = 0; j < COLUMNAS; j++) { 

                    if (casilleros[i][j].getNumero() == numeroCasillero) { 

                        encontrado = true; 

                        Casillero casilleroEncontrado = casilleros[i][j]; 

                         

                        System.out.println("\n--- Información del Casillero #" + numeroCasillero + " ---"); 

                        System.out.println("Tamaño: " + casilleroEncontrado.getTamano()); 

 

                        if (casilleroEncontrado.estaOcupado()) { 

                            System.out.println("Estado: Ocupado"); 

                            // Muestra el paquete usando el método toString() del objeto Paquete. 

                            System.out.println("Detalles del paquete: " + casilleroEncontrado.getPaqueteAsignado()); 

                        } else { 

                            System.out.println("Estado: Vacío"); 

                        } 

                        break; 

                    } 

                } 

                if (encontrado) { 

                    break; 

                } 

            } 

            if (!encontrado) { 

                System.out.println("Número de casillero no válido."); 

            } 

        } catch (java.util.InputMismatchException e) { 

            System.out.println("Entrada no válida. Por favor, ingrese un número."); 

            scanner.nextLine(); 

        } 

    } 

 

    /** 

     * Permite al usuario desocupar un casillero específico por su número. 

     * Si el casillero está ocupado, lo restablece a un estado vacío. 

     */ 

    private static void desocuparCasillero() { 

        System.out.print("Ingrese el número del casillero a desocupar: "); 

        try { 

            int numeroCasillero = scanner.nextInt(); 

            scanner.nextLine(); 

 

            boolean encontrado = false; 

            for (int i = 0; i < FILAS; i++) { 

                for (int j = 0; j < COLUMNAS; j++) { 

                    if (casilleros[i][j].getNumero() == numeroCasillero) { 

                        encontrado = true; 

                        if (casilleros[i][j].estaOcupado()) { 

                            casilleros[i][j].desocuparCasillero(); 

                            System.out.println("✅ El casillero #" + numeroCasillero + " ha sido desocupado."); 

                        } else { 

                            System.out.println("El casillero #" + numeroCasillero + " ya está vacío."); 

                        } 

                        break; 

                    } 

                } 

                if (encontrado) { 

                    break; 

                } 

            } 

            if (!encontrado) { 

                System.out.println("Número de casillero no válido."); 

            } 

        } catch (java.util.InputMismatchException e) { 

            System.out.println("Entrada no válida. Por favor, ingrese un número."); 

            scanner.nextLine(); 

        } 

    } 

} 
 
 