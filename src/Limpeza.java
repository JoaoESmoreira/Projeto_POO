import java.io.Serializable;

/**
 * The type Limpeza.
 */
public class Limpeza extends Produto implements Serializable {
    private int tox;

    /**
     * Instantiates a new Limpeza.
     */
    public Limpeza() {
    }

    /**
     * Instantiates a new Limpeza.
     *
     * @param id    the id
     * @param stock the stock
     * @param preco the preco
     * @param nome  the nome
     * @param tox   the tox
     * @param promo the promo
     */
    public Limpeza(int id, int stock, int preco, String nome, int tox, int promo) {
        super(id, stock, preco, nome, promo);
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

    /**
     * Gets tox.
     *
     * @return the tox
     */
    public int getTox() {
        return tox;
    }

    /**
     * Sets tox.
     *
     * @param tox the tox
     */
    public void setTox(int tox) {
        this.tox = tox;
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
                "Toxicidade: " + tox + "\n";
    }
}