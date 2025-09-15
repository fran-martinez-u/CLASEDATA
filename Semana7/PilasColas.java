import java.util.Stack;

public class PilasColas {

    public static void main(String[] args) {

        // Creamos una pila. Una pila es como una pila de platos: el último que pones es el primero que sacas.
        Stack<Integer> pila = new Stack<>(); 

        // Metemos números en la pila. Esto se llama "push".
        pila.push(10);
        pila.push(20);
        pila.push(5);
        pila.push(9);
        pila.push(35); // La pila ahora tiene 10, 20, 5, 9, y el último que pusimos es el 35.

        // Preguntamos cosas sobre la pila.
        System.out.println("El tamaño es: " + pila.size()); // ¿Cuántos números hay? Hay 5.
        System.out.println("¿Está vacía? " + pila.empty()); // No, no está vacía.
        System.out.println("Contenido de la pila: " + pila); // Vemos todos los números: [10, 20, 5, 9, 35].

        // Vemos el número de arriba sin quitarlo. Esto se llama "peek".
        System.out.println("El número de arriba es: " + pila.peek()); // Es el 35.

        // Quitamos el número de arriba. Esto se llama "pop".
        pila.pop(); // Ahora el 35 se ha ido.

        // Volvemos a ver el número de arriba.
        System.out.println("Ahora el número de arriba es: " + pila.peek()); // Ahora es el 9.

        // Vemos cómo quedó la pila.
        System.out.println("Pila sin el 35: " + pila); // Vemos [10, 20, 5, 9].

        // Buscamos un número y nos dice su posición desde arriba. El número 1 es el de arriba.
        System.out.println("El número 9 está en la posición: " + pila.search(9)); // Está en la posición 1.
    }
}