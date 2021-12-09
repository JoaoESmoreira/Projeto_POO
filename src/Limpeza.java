import java.io.Serializable;

/**
 * The type Cleaning Product.
 */
public class Limpeza extends Produto implements Serializable {
    private int tox;

    /**
     * Instantiates a new Cleaning Object.
     */
    public Limpeza() {
    }

    /**
     * Instantiates a new Cleaning Object.
     *
     * @param id    the id
     * @param stock the stock
     * @param preco the price
     * @param nome  the name
     * @param tox   the toxicity
     * @param promo the type of promotion
     */
    public Limpeza(int id, int stock, int preco, String nome, int tox, int promo) {
        super(id, stock, preco, nome, promo);
        this.tox = tox;
    }

    /**
     * Gets toxicity.
     *
     * @return the toxicity.
     */
    public int getTox() {
        return tox;
    }

    /**
     * Sets toxicity.
     *
     * @param tox the toxicity.
     */
    public void setTox(int tox) {
        this.tox = tox;
    }

    public int getPeso() {
        return -1;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
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

    /**
     * Print Attributes
     *
     * @return the string that contains all attributes of this product
     */
    public String print () {
        return nome + "\nID:                    " + id +
                      "\nPreco:                 " + preco +
                      "\nToxicidade:            " + tox + "\n";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Toxicidade: " + tox + "\n";
    }
}