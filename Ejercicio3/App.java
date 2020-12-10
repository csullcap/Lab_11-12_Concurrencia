
public class App {

    public static void main(String[] args) {
        String productosCliente1[] = { "arroz", "carnes", "legumbres", "gelatina", "pan" };
        String productosCliente2[] = { "leche", "huevos", "lentejas", "pan", "gaseosa" };
        Cliente cliente1;
        Cliente cliente2;
        Cajero cajero1;
        Cajero cajero2;
        long initialTime = System.currentTimeMillis();
        cliente1 = new Cliente("Juan", productosCliente1);
        cliente2 = new Cliente("Pedro", productosCliente2);
        cajero1 = new Cajero("Caja nro 1", cliente1, initialTime);
        cajero2 = new Cajero("Caja nro 2 ", cliente2, initialTime);

        cajero1.start();
        cajero2.start();

    }
}