import java.util.List;
import java.util.Scanner;

public class Utils {
    // a. Registrar pedido
    public static Pedido registrarPedido(Scanner sc) {
        sc.nextLine();
        System.out.print("   Nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("   Plato solicitado: ");
        String plato = sc.nextLine();
        System.out.print("   Cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("   Precio unitario: $");
        double precio = sc.nextDouble();
        return new Pedido(nombre, plato, cantidad, precio);
    }

    // b. Mostrar total por cada pedido
    public static void mostrarTotalesPorPedido(List<Pedido> lista) {
        System.out.println("\n--- TOTAL A PAGAR POR PEDIDO ---");
        System.out.printf("%-18s %-20s %-10s %-12s %-10s %-10s%n",
                "Cliente", "Plato", "Cantidad", "P.Unitario", "Subtotal", "Total");
        System.out.println("-".repeat(82));
        for (Pedido p : lista) {
            System.out.printf("%-18s %-20s %-10d $%-11.2f $%-9.2f %s$%.2f%n",
                    p.getNombre(), p.getPlato(), p.getCantidad(),
                    p.getPrecioUnitario(), p.getSubtotal(),
                    p.aplicaDescuento() ? "(-10%) $" : "       $",
                    p.getTotalConDescuento());
        }
    }

    // d. Ingreso total del restaurante
    public static double calcularIngresoTotal(List<Pedido> lista) {
        double total = 0;
        for (Pedido p : lista)
            total += p.getTotalConDescuento();
        return total;
    }

    // e. Pedido de mayor valor
    public static Pedido pedidoMayorValor(List<Pedido> lista) {
        if (lista.isEmpty()) return null;
        Pedido mayor = lista.get(0);
        for (Pedido p : lista)
            if (p.getTotalConDescuento() > mayor.getTotalConDescuento())
                mayor = p;
        return mayor;
    }
}
