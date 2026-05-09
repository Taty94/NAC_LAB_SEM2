import java.util.Scanner;

public class Utils {
    public static void registrarEmpleados(int[] codigos, String[] nombres, Scanner scanner) {
        for (int i = 0; i < codigos.length; i++) {
            System.out.println("\n--- Empleado " + (i + 1) + " ---");
            System.out.print("Código: ");
            codigos[i] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();
        }
    }

    public static void buscarPorCodigo(int[] codigos, String[] nombres, int codigoBuscado) {
        boolean encontrado = false;
        for (int i = 0; i < codigos.length; i++) {
            if (codigos[i] == codigoBuscado) {
                System.out.println("Empleado encontrado: " + nombres[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado)
            System.out.println("No se encontró ningún empleado con el código " + codigoBuscado);
    }
}
