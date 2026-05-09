import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE VENTAS DE FABRICA ===\n");
        System.out.print("Ingrese el numero de articulos (N): ");
        int n = scanner.nextInt();
        System.out.print("Ingrese el numero de sucursales (M): ");
        int m = scanner.nextInt();

        double[][] precios    = Utils.generarPrecios(n, m);
        int[][]    cantidades = Utils.generarCantidades(n, m);

        System.out.println("\n--- TABLA DE PRECIOS (por sucursal) ---");
        Utils.imprimirTablaPrecios(precios, n, m);

        System.out.println("\n--- TABLA DE CANTIDADES VENDIDAS ---");
        Utils.imprimirTablaCantidades(cantidades, n, m);

        // Total ventas por artículo
        double[] ventasArticulo = Utils.totalVentasPorArticulo(precios, cantidades, n, m);
        System.out.println("\n--- TOTAL DE VENTAS POR ARTICULO ---");
        for (int i = 0; i < n; i++)
            System.out.printf("Articulo %d: $%.2f%n", (i + 1), ventasArticulo[i]);

        // Total ventas por sucursal
        double[] ventasSucursal = Utils.totalVentasPorSucursal(precios, cantidades, n, m);
        System.out.println("\n--- TOTAL DE VENTAS POR SUCURSAL ---");
        for (int j = 0; j < m; j++)
            System.out.printf("Sucursal %d: $%.2f%n", (j + 1), ventasSucursal[j]);

        scanner.close();
    }
}