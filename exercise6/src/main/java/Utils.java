import java.util.Random;

public class Utils {
    static Random rand = new Random();

    public static double[][] generarVentas(int n, int m) {
        double[][] ventas = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                ventas[i][j] = Math.round((rand.nextDouble() * 9000 + 1000) * 100.0) / 100.0;
        return ventas;
    }

    public static void imprimirMatriz(double[][] ventas, int n, int m) {
        System.out.printf("%-15s", "");
        for (int j = 0; j < m; j++)
            System.out.printf("%-15s", "Año " + (j + 1));
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s", "Vendedor " + (i + 1));
            for (int j = 0; j < m; j++)
                System.out.printf("%-15s", "$" + ventas[i][j]);
            System.out.println();
        }
    }

    public static double[] totalPorVendedor(double[][] ventas, int n, int m) {
        double[] totales = new double[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                totales[i] += ventas[i][j];
        return totales;
    }

    public static double[] totalPorAnio(double[][] ventas, int n, int m) {
        double[] totales = new double[m];
        for (int j = 0; j < m; j++)
            for (int i = 0; i < n; i++)
                totales[j] += ventas[i][j];
        return totales;
    }

    public static double totalEmpresa(double[] totalesPorVendedor) {
        double total = 0;
        for (double t : totalesPorVendedor)
            total += t;
        return total;
    }
}
