import java.io.Serializable;

/**
 * The type Mobiliario.
 */
public class Mobiliario extends Produto implements Serializable {
    private int peso;
    private Dimensao dim;

    /**
     * Instantiates new Furniture.
     */
    public Mobiliario(){}

    /**
     * Instantiates new Furniture.
     *
     * @param id    the id
     * @param stock the stock
     * @param preco the price
     * @param nome  the name
     * @param peso  the weight
     * @param dim   the dimension
     * @param promo the promotion
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
     * Sets weight.
     *
     * @param peso the weight
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * Gets dimension.
     *
     * @return the dimension
     */
    public Dimensao getDim() {
        return dim;
    }

    /**
     * Sets dimension.
     *
     * @param dim the dimension
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