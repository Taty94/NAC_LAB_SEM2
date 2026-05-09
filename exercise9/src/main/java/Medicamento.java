import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Medicamento {
    private String nombre;
    private int    stockActual;
    private int    stockMinimo;
    private double precioUnitario;

    public boolean stockBajoMinimo() { return stockActual < stockMinimo; }

    public double valorEnInventario() { return stockActual * precioUnitario; }

    @Override
    public String toString() {
        return String.format("%-20s Stock: %-6d Min: %-6d Precio: $%-8.2f Valor: $%.2f %s",
                nombre, stockActual, stockMinimo, precioUnitario,
                valorEnInventario(),
                stockBajoMinimo() ? "[BAJO MINIMO]" : "");
    }
}
