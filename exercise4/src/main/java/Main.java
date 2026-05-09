import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== OPERACIONES CON MATRICES ===\n");
        System.out.print("Ingrese filas (M): ");
        int m = scanner.nextInt();
        System.out.print("Ingrese columnas (N): ");
        int n = scanner.nextInt();

        int[][] matrizA = Utils.generarMatriz(m, n);
        int[][] matrizB = Utils.generarMatriz(m, n);

        System.out.println("\nMatriz A:");
        Utils.imprimirMatriz(matrizA);
        System.out.println("Matriz B:");
        Utils.imprimirMatriz(matrizB);

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Sumar matrices");
            System.out.println("2. Restar matrices");
            System.out.println("3. Multiplicar matrices");
            System.out.println("4. Trasponer Matriz A");
            System.out.println("5. Trasponer Matriz B");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nResultado A + B:");
                    Utils.imprimirMatriz(Utils.sumar(matrizA, matrizB));
                    break;
                case 2:
                    System.out.println("\nResultado A - B:");
                    Utils.imprimirMatriz(Utils.restar(matrizA, matrizB));
                    break;
                case 3:
                    int[][] producto = Utils.multiplicar(matrizA, matrizB);
                    if (producto != null) {
                        System.out.println("\nResultado A x B:");
                        Utils.imprimirMatriz(producto);
                    } else {
                        System.out.println("No se puede multiplicar: columnas de A deben ser iguales a filas de B.");
                    }
                    break;
                case 4:
                    System.out.println("\nTranspuesta de A:");
                    Utils.imprimirMatriz(Utils.trasponer(matrizA));
                    break;
                case 5:
                    System.out.println("\nTranspuesta de B:");
                    Utils.imprimirMatriz(Utils.trasponer(matrizB));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
        scanner.close();
    }
}
