import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CONSOLIDADO DE VENTAS ===\n");
        System.out.print("Ingrese el numero de vendedores (N): ");
        int n = scanner.nextInt();
        System.out.print("Ingrese el numero de años (M): ");
        int m = scanner.nextInt();

        double[][] ventas = Utils.generarVentas(n, m);

        System.out.println("\n--- MATRIZ DE VENTAS ---");
        Utils.imprimirMatriz(ventas, n, m);

        // a. Total por vendedor
        double[] totalVendedor = Utils.totalPorVendedor(ventas, n, m);
        System.out.println("\na. TOTAL DE VENTAS POR VENDEDOR:");
        for (int i = 0; i < n; i++)
            System.out.printf("   Vendedor %d: $%.2f%n", (i + 1), totalVendedor[i]);

        // b. Total por año
        double[] totalAnio = Utils.totalPorAnio(ventas, n, m);
        System.out.println("\nb. TOTAL DE VENTAS POR AÑO:");
        for (int j = 0; j < m; j++)
            System.out.printf("   Año %d: $%.2f%n", (j + 1), totalAnio[j]);

        // c. Total empresa
        double totalEmpresa = Utils.totalEmpresa(totalVendedor);
        System.out.printf("\nc. TOTAL GENERAL DE LA EMPRESA: $%.2f%n", totalEmpresa);

        scanner.close();
        
    }
}