import java.io.*;
import java.util.ArrayList;

/**
 * The type Reads and Writes Objects Files.
 */
public class LerFicheiroObjetos {
    private ArrayList<Vendas> venda;
    private String titulo;

    /**
     * Instantiates a Read Objects File.
     */
    public LerFicheiroObjetos() {
        venda = new ArrayList<>();
    }

    /**
     * Instantiates a new Read Objects File.
     *
     * @param titulo the title
     */
    public LerFicheiroObjetos(String titulo) {
        venda = new ArrayList<>();
        this.titulo = titulo;
    }

    /**
     * Gets Sell.
     *
     * @return the sell
     */
    public ArrayList<Vendas> getVenda() {
        return venda;
    }

    /**
     * Sets Sell.
     *
     * @param vendas the sell
     */
    public void setVendas(ArrayList<Vendas> vendas) {
        this.venda = vendas;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets title.
     *
     * @param titulo the title
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Add a purchase.
     *
     * @param vendas the purchase.
     */
    public void addVendas(Vendas vendas) {
        this.venda.add(vendas);
    }

    /**
     * So quero ler um.
     *
     * Read the file and add the Purchase Object to an ArrayList.
     */
    public void soQueroLerUm () {
        File f = new File(titulo);

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Vendas vendas;
            while ((vendas = (Vendas) ois.readObject()) != null) {
                // vendas = (Vendas) ois.readObject();
                addVendas(vendas);

            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write
     *
     * Write all Purchase Objects in the ArrayList.
     */
    public void escrita () {

        for (Vendas vendas : venda) {

            File f = new File(vendas.getCliente().getNome());

            try {
                FileOutputStream fos = new FileOutputStream(f, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(vendas);

                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Print text.
     *
     * Print an ArrayList that contains all lines of a text read before.
     */
    public void printTexto() {
        for (Vendas vendas : venda) {
            System.out.println("Voce ja comprou :");
            vendas.printListaCompras();
            System.out.println("\n\n Já gastou: " + vendas.getCusto());
        }
    }
}
