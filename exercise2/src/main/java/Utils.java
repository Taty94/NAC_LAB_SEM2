import java.util.Random;

public class Utils {
    public static int[] generarVector(int tamanio) {
        Random rand = new Random();
        int[] vector = new int[tamanio];
        for (int i = 0; i < tamanio; i++)
            vector[i] = rand.nextInt(50) + 1;
        return vector;
    }

    public static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++)
            System.out.print("[" + i + "]=" + vector[i] + "  ");
        System.out.println();
    }

    // a. Buscar número y mostrar posiciones
    public static void buscarNumero(int[] vector, int numeroBuscado) {
        boolean encontrado = false;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == numeroBuscado) {
                System.out.println("Número " + numeroBuscado + " encontrado en la posición: " + i);
                encontrado = true;
            }
        }
        if (!encontrado)
            System.out.println("El número " + numeroBuscado + " no se encuentra en el vector.");
    }

    // b. Crear vector con elementos de índices impares
    public static int[] extraerIndicesImpares(int[] vector) {
        int[] resultado = new int[vector.length / 2];
        int j = 0;
        for (int i = 1; i < vector.length; i += 2)
            resultado[j++] = vector[i];
        return resultado;
    }

    // c. Contar elementos mayores a un valor dado
    public static int contarMayoresA(int[] vector, int valor) {
        int contador = 0;
        for (int elemento : vector)
            if (elemento > valor)
                contador++;
        return contador;
    }
}
