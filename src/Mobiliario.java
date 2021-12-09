import java.io.Serializable;

/**
 * The type Mobiliario.
 */
public class Mobiliario extends Produto implements Serializable {
    private int peso;
    private Dimensao dim;

    /**
     * Instantiates a new Mobiliario.
     */
    public Mobiliario(){}

    /**
     * Instantiates a new Mobiliario.
     *
     * @param id    the id
     * @param stock the stock
     * @param preco the preco
     * @param nome  the nome
     * @param peso  the peso
     * @param dim   the dim
     * @param promo the promo
     */
    public Mobiliario(int id, int stock, int preco, String nome, int peso, Dimensao dim, int promo) {
        super(id, stock, preco, nome, promo);
        this.peso = peso;
        this.dim = dim;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public int getPeso() {
        return peso;
    }

    /**
     * Sets peso.
     *
     * @param peso the peso
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Gets dim.
     *
     * @return the dim
     */
    public Dimensao getDim() {
        return dim;
    }

    /**
     * Sets dim.
     *
     * @param dim the dim
     */
    public void setDim(Dimensao dim) {
        this.dim = dim;
    }


    public int getId() {
        return super.getId();
    }
    public void setId(int id) {
        super.setId(id);
    }

    public int getStock() {
        return super.getStock();
    }
    public void setStock(int stock) {
        super.setStock(stock);
    }

    public String getNome() {
        return super.getNome();
    }
    public void setNome(String nome) {
        super.setNome(nome);
    }

    public void setPreco(int preco) {
        super.setPreco(preco);
    }
    public int getPreco() {
        return super.getPreco();
    }

    @Override
    public String toString() {
        return super.toString() +
                "Peso: " + peso +
                "\nDimensao: " + dim + "\n";
    }
}