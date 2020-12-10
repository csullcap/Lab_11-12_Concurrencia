import java.util.Random;

public class Cajero extends Thread {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    Cajero() {
        this.cliente = null;
    }

    public Cajero(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int temp;
        System.out.println("LA " + this.nombre.toUpperCase() + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre().toUpperCase());

        for (int i = 0; i < this.cliente.getProductos().length; i++) {
            temp = rand.nextInt(3) + 1;
            this.esperar(temp);
            System.out.println("PROCESANDO EL PRODUCTO " + (cliente.getProductos()[i].toUpperCase()) + " DEL CLIENTE "
                    + this.cliente.getNombre().toUpperCase() + " EN LA " + this.nombre.toUpperCase() + " TIEMPO USADO "
                    + temp + "seg");
        }

        System.out.println("LA " + this.nombre.toUpperCase()
                + " HA TERMINADO DE PROCESAR TODOS LOS PRODUCTOS DEL CLIENTE " + this.cliente.getNombre().toUpperCase()
                + " EN " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
    }

    private void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}