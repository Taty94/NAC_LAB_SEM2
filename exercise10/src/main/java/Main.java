import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n========= RESTAURANTE - PEDIDOS =========");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Ver totales por pedido");
            System.out.println("3. Ver ingreso total del restaurante");
            System.out.println("4. Ver pedido de mayor valor");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR PEDIDO ---");
                    pedidos.add(Utils.registrarPedido(sc));
                    System.out.println("  Pedido registrado correctamente.");
                    break;
                case 2:
                    if (pedidos.isEmpty()) {
                        System.out.println("  No hay pedidos registrados.");
                    } else {
                        Utils.mostrarTotalesPorPedido(pedidos);
                    }
                    break;
                case 3:
                    System.out.printf("%nINGRESO TOTAL DEL RESTAURANTE: $%.2f%n",
                            Utils.calcularIngresoTotal(pedidos));
                    break;
                case 4:
                    Pedido mayor = Utils.pedidoMayorValor(pedidos);
                    if (mayor == null) {
                        System.out.println("  No hay pedidos registrados.");
                    } else {
                        System.out.println("\n--- PEDIDO DE MAYOR VALOR ---");
                        System.out.println("  " + mayor);
                    }
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