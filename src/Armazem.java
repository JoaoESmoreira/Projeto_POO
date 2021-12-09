import java.util.ArrayList;
import java.util.Objects;

/**
 * The type Armazem.
 */
public class Armazem {
    private ArrayList<Produto> armazem;

    /**
     * Instantiates a new Storage (ArrayList of Products).
     */
    public Armazem () {
        this.armazem = new ArrayList<>();
    }

    /**
     * Instantiates a new Storage (ArrayList of Products).
     *
     * @param armazem the armazem
     */
    public Armazem (ArrayList<Produto> armazem) {
        this.armazem = armazem;
    }

    /**
     * Gets Storage (ArrayList of Products).
     *
     * @return the armazem
     */
    public ArrayList<Produto> getArmazem() {
        return armazem;
    }

    /**
     * Sets Storage (ArrayList of Products).
     *
     * @param armazem the armazem
     */
    public void setArmazem(ArrayList<Produto> armazem) {
        this.armazem = armazem;
    }

    /**
     * Add stock.
     *
     * The function read the inventory file and put the products on Storage (ArrayList of products).
     *
     * @param file the file
     */
    public void addStock(String file) {
        // leitura do ficheiro

        LeituraFicheiros ficheiro = new LeituraFicheiros();
        ficheiro.setTitulo(file);
        ficheiro.leitura();

        ArrayList<String> linhas = ficheiro.getLines();

        // adicionar os produtos ao arraylist
        for (String s : linhas) {
            String[] dados = s.split(",");

            String t = dados[0];

            if (Objects.equals(t, "a")) {
                armazem.add(new Alimentar(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), dados[6], Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[7])));
            } else if (t.equals("l")) {
                armazem.add(new Limpeza(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), dados[5], Integer.parseInt(dados[4]), Integer.parseInt(dados[6])));
            } else if (t.equals("m")) {
                String[] dim = dados[5].split("/");
                Dimensao d = new Dimensao(Integer.parseInt(dim[0]), Integer.parseInt(dim[1]), Integer.parseInt(dim[2]));
                armazem.add(new Mobiliario(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), dados[6], Integer.parseInt(dados[4]), d, Integer.parseInt(dados[7])));
            }
        }
    }

    /**
     * Produto no armazem.
     *
     * Given Id, if there is a respective object in Stock, the function will return this Product object.
     *
     * @param id the id
     * @return the produto
     */
    public Produto produtoNoArmazem (int id) {
        Produto flag = null;
        for (Produto produto : armazem) {
            if (produto.getId() == id)
                flag = produto;
        }
        return flag;
    }


    /**
     * Print armazem.
     *
     * Print all storage in stock
     *
     */
    public void printArmazem() {
        for (Produto p : armazem) {
            System.out.println(p);
        }
    }
}
