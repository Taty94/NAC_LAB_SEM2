import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pedido {
    private String nombre;
    private String plato;
    private int    cantidad;
    private double precioUnitario;

    public double getSubtotal() {
        return cantidad * precioUnitario;
    }

    public boolean aplicaDescuento() {
        return getSubtotal() > 50;
    }

    public double getTotalConDescuento() {
        double subtotal = getSubtotal();
        return aplicaDescuento() ? subtotal * 0.90 : subtotal;
    }

    @Override
    public String toString() {
        return String.format("%-18s %-20s Cant: %-4d P.Unit: $%-8.2f Subtotal: $%-8.2f %s Total: $%.2f",
                nombre, plato, cantidad, precioUnitario, getSubtotal(),
                aplicaDescuento() ? "(-10%)" : "      ",
                getTotalConDescuento());
    }
}
