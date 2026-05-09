import java.util.Random;

public class Utils {
    static Random rand = new Random();

    public static double[][] generarPrecios(int n, int m) {
        double[][] precios = new double[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                precios[i][j] = Math.round((rand.nextDouble() * 90 + 10) * 100.0) / 100.0;
        return precios;
    }

    public static int[][] generarCantidades(int n, int m) {
        int[][] cantidades = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                cantidades[i][j] = rand.nextInt(50) + 1;
        return cantidades;
    }

    public static void imprimirTablaPrecios(double[][] precios, int n, int m) {
        System.out.printf("%-15s", "");
        for (int j = 0; j < m; j++)
            System.out.printf("%-15s", "Sucursal " + (j + 1));
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s", "Articulo " + (i + 1));
            for (int j = 0; j < m; j++)
                System.out.printf("%-15s", "$" + precios[i][j]);
            System.out.println();
        }
    }

    public static void imprimirTablaCantidades(int[][] cantidades, int n, int m) {
        System.out.printf("%-15s", "");
        for (int j = 0; j < m; j++)
            System.out.printf("%-15s", "Sucursal " + (j + 1));
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s", "Articulo " + (i + 1));
            for (int j = 0; j < m; j++)
                System.out.printf("%-15d", cantidades[i][j]);
            System.out.println();
        }
    }

    public static double[] totalVentasPorArticulo(double[][] precios, int[][] cantidades, int n, int m) {
        double[] totales = new double[n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                totales[i] += precios[i][j] * cantidades[i][j];
        return totales;
    }

    public static double[] totalVentasPorSucursal(double[][] precios, int[][] cantidades, int n, int m) {
        double[] totales = new double[m];
        for (int j = 0; j < m; j++)
            for (int i = 0; i < n; i++)
                totales[j] += precios[i][j] * cantidades[i][j];
        return totales;
    }
}
