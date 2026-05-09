import java.util.Random;

public class Utils {
    static Random rand = new Random();

    public static int[] generarCodigos(int n) {
        int[] codigos = new int[n];
        for (int i = 0; i < n; i++)
            codigos[i] = 100 + (i + 1);
        return codigos;
    }

    public static double[] generarHorasAusencia(int n) {
        double[] horas = new double[n];
        for (int i = 0; i < n; i++)
            horas[i] = Math.round((rand.nextDouble() * 8) * 10.0) / 10.0;
        return horas;
    }

    public static int[] generarDefectuosos(int n) {
        int[] defectuosos = new int[n];
        for (int i = 0; i < n; i++)
            defectuosos[i] = rand.nextInt(500);
        return defectuosos;
    }

    public static int[] generarProducidos(int n) {
        int[] producidos = new int[n];
        for (int i = 0; i < n; i++)
            producidos[i] = rand.nextInt(8000) + 7000;
        return producidos;
    }

    public static int calcularGrado(double horas, int defectuosos, int producidos) {
        boolean c1 = horas       <= 3;
        boolean c2 = defectuosos <  300;
        boolean c3 = producidos  >  10000;

        if  ( c1 &&  c2 &&  c3) return 20;
        if  ( c1 &&  c2 && !c3) return 12;
        if  ( c1 && !c2 &&  c3) return 13;
        if  (!c1 &&  c2 &&  c3) return 15;
        if  ( c1 && !c2 && !c3) return 7;
        if  (!c1 &&  c2 && !c3) return 8;
        if  (!c1 && !c2 &&  c3) return 9;
        return 5;
    }

    public static void imprimirReporte(int[] codigos, double[] horas,
                                       int[] defectuosos, int[] producidos,
                                       int[] grados, int n) {
        System.out.printf("%-10s %-15s %-20s %-20s %-8s%n",
                "Codigo", "Hs. Ausencia", "Defectuosos", "Producidos", "Grado");
        System.out.println("-".repeat(75));
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-15.1f %-20d %-20d %-8d%n",
                    codigos[i], horas[i], defectuosos[i], producidos[i], grados[i]);
        }
    }
}
