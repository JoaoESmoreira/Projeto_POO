import java.io.*;
import java.util.ArrayList;

/**
 * The type Ler ficheiro objetos.
 */
public class LerFicheiroObjetos {
    private ArrayList<Vendas> venda;
    private String titulo;

    /**
     * Instantiates a new Ler ficheiro objetos.
     */
    public LerFicheiroObjetos() {
        venda = new ArrayList<>();
    }

    /**
     * Instantiates a new Ler ficheiro objetos.
     *
     * @param titulo the titulo
     */
    public LerFicheiroObjetos(String titulo) {
        venda = new ArrayList<>();
        this.titulo = titulo;
    }

    /**
     * Gets venda.
     *
     * @return the venda
     */
    public ArrayList<Vendas> getVenda() {
        return venda;
    }

    /**
     * Sets vendas.
     *
     * @param vendas the vendas
     */
    public void setVendas(ArrayList<Vendas> vendas) {
        this.venda = vendas;
    }

    /**
     * Gets titulo.
     *
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets titulo.
     *
     * @param titulo the titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Add vendas.
     *
     * @param vendas the vendas
     */
    public void addVendas(Vendas vendas) {
        this.venda.add(vendas);
    }

    /**
     * So quero ler um.
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
     * Escrita 2.
     */
    public void escrita2 () {

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
     * Print texto.
     */
    public void printTexto() {
        for (Vendas vendas : venda) {
            System.out.println("Voce ja comprou :");
            vendas.printListaCompras();
            System.out.println("\n\n Já gastou: " + vendas.getCusto());
        }
    }
}
