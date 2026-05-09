import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Medicamento> inventario = new ArrayList<>();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n========= FARMACIA - INVENTARIO =========");
            System.out.println("1. Registrar medicamento");
            System.out.println("2. Ver medicamentos bajo stock minimo");
            System.out.println("3. Ver valor total del inventario");
            System.out.println("4. Actualizar stock por venta");
            System.out.println("5. Reporte general");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR MEDICAMENTO ---");
                    inventario.add(Utils.registrarMedicamento(sc));
                    System.out.println("  Medicamento registrado correctamente.");
                    break;
                case 2:
                    Utils.mostrarBajoMinimo(inventario);
                    break;
                case 3:
                    System.out.printf("%nVALOR TOTAL DEL INVENTARIO: $%.2f%n",
                            Utils.calcularValorTotal(inventario));
                    break;
                case 4:
                    Utils.actualizarStock(inventario, sc);
                    break;
                case 5:
                    Utils.mostrarReporte(inventario);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
        sc.close();
    }
}