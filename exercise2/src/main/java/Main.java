import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vector = Utils.generarVector(20);
        System.out.println("Vector original:");
        Utils.imprimirVector(vector);

        // a. Buscar número
        System.out.print("\nIngrese un número a buscar: ");
        int numeroBuscado = scanner.nextInt();
        Utils.buscarNumero(vector, numeroBuscado);

        // b. Vector de índices impares
        int[] vectorImpares = Utils.extraerIndicesImpares(vector);
        System.out.println("\nVector con elementos de índices impares:");
        Utils.imprimirVector(vectorImpares);

        // c. Contar mayores a 20
        int cantidad = Utils.contarMayoresA(vectorImpares, 20);
        System.out.println("\nCantidad de elementos mayores a 20 en el segundo vector: " + cantidad);

        scanner.close();

    }
}