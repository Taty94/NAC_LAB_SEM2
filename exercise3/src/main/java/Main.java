import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de empleados (N): ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        int[]    codigos = new int[numero];
        String[] nombres = new String[numero];

        Utils.registrarEmpleados(codigos, nombres, scanner);

        System.out.print("\nIngrese el código a buscar: ");
        int codigoBuscado = scanner.nextInt();

        Utils.buscarPorCodigo(codigos, nombres, codigoBuscado);

        scanner.close();

    }
}