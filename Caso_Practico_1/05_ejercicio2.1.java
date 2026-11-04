import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<String, Producto> productos;

    public Inventario() {
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto != null) {
            productos.put(producto.getCodigo(), producto);
        }
    }

    public Producto buscarProducto(String codigo) throws ProductoNoEncontradoException {
        Producto producto = productos.get(codigo);
        if (producto == null) {
            throw new ProductoNoEncontradoException("El producto con código '" + codigo + "' no fue encontrado.");
        }
        return producto;
    }

    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("=== LISTADO DE INVENTARIO - TIENDA EL ÉXITO ===");
        for (Producto p : productos.values()) {
            System.out.println(p.toString());
        }
    }
}
