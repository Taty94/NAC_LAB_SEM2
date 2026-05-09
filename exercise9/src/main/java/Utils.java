import java.util.List;
import java.util.Scanner;

public class Utils {
    // a. Registrar medicamento
    public static Medicamento registrarMedicamento(Scanner sc) {
        sc.nextLine();
        System.out.print("   Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("   Stock actual: ");
        int stockActual = sc.nextInt();
        System.out.print("   Stock minimo: ");
        int stockMinimo = sc.nextInt();
        System.out.print("   Precio unitario: $");
        double precio = sc.nextDouble();
        return new Medicamento(nombre, stockActual, stockMinimo, precio);
    }

    // b. Medicamentos bajo stock mínimo
    public static void mostrarBajoMinimo(List<Medicamento> lista) {
        System.out.println("\n--- MEDICAMENTOS BAJO STOCK MINIMO ---");
        boolean hayAlguno = false;
        for (Medicamento m : lista) {
            if (m.stockBajoMinimo()) {
                System.out.println("  " + m);
                hayAlguno = true;
            }
        }
        if (!hayAlguno)
            System.out.println("  Todos los medicamentos tienen stock suficiente.");
    }

    // c. Valor total del inventario
    public static double calcularValorTotal(List<Medicamento> lista) {
        double total = 0;
        for (Medicamento m : lista)
            total += m.valorEnInventario();
        return total;
    }

    // d. Actualizar stock tras venta
    public static void actualizarStock(List<Medicamento> lista, Scanner sc) {
        System.out.println("\n--- ACTUALIZAR STOCK POR VENTA ---");
        System.out.print("  Nombre del medicamento: ");
        sc.nextLine();
        String nombre = sc.nextLine();

        Medicamento encontrado = null;
        for (Medicamento m : lista)
            if (m.getNombre().equalsIgnoreCase(nombre))
                encontrado = m;

        if (encontrado == null) {
            System.out.println("  Medicamento no encontrado.");
            return;
        }

        System.out.print("  Cantidad vendida: ");
        int cantidad = sc.nextInt();

        if (cantidad > encontrado.getStockActual()) {
            System.out.println("  Stock insuficiente. Disponible: " + encontrado.getStockActual());
        } else {
            encontrado.setStockActual(encontrado.getStockActual() - cantidad);
            System.out.printf("  Stock actualizado. Nuevo stock de '%s': %d%n",
                    encontrado.getNombre(), encontrado.getStockActual());
            if (encontrado.stockBajoMinimo())
                System.out.println("  ADVERTENCIA: Stock por debajo del minimo.");
        }
    }

    // e. Reporte general
    public static void mostrarReporte(List<Medicamento> lista) {
        System.out.println("\n--- REPORTE GENERAL DEL INVENTARIO ---");
        System.out.printf("%-20s %-10s %-10s %-12s %-12s %-15s%n",
                "Nombre", "Stock", "Minimo", "Precio", "Valor", "Estado");
        System.out.println("-".repeat(82));
        for (Medicamento m : lista) {
            System.out.printf("%-20s %-10d %-10d $%-11.2f $%-11.2f %-15s%n",
                    m.getNombre(), m.getStockActual(), m.getStockMinimo(),
                    m.getPrecioUnitario(), m.valorEnInventario(),
                    m.stockBajoMinimo() ? "BAJO MINIMO" : "OK");
        }
        System.out.printf("%nVALOR TOTAL DEL INVENTARIO: $%.2f%n", calcularValorTotal(lista));
    }
}
