import java.io.Serializable;

/**
 * The type Produto.
 */
abstract class Produto implements Serializable {
    /**
     * The Id.
     */
    protected int id, /**
     * The Stock.
     */
    stock, /**
     * The Preco.
     */
    preco, /**
     * The Promo.
     */
    promo;
    /**
     * The Nome.
     */
    protected String nome;

    /**
     * Instantiates a new Produto.
     */
    public Produto(){}

    /**
     * Instantiates a new Produto.
     *
     * @param id    the id
     * @param stock the stock
     * @param preco the preco
     * @param nome  the nome
     * @param promo the promo
     */
    public Produto(int id, int stock, int preco, String nome, int promo) {
        this.id = id;
        this.stock = stock;
        this.preco = preco;
        this.nome = nome;
        this.promo = promo;
    }

    /**
     * Gets peso.
     *
     * @return the peso
     */
    public abstract int getPeso();

    /**
     * Gets promo.
     *
     * @return the promo
     */
    public int getPromo() {
        return promo;
    }

    /**
     * Sets promo.
     *
     * @param promo the promo
     */
    public void setPromo(int promo) {
        this.promo = promo;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Sets preco.
     *
     * @param preco the preco
     */
    public void setPreco (int preco) {
        this.preco = preco;
    }

    /**
     * Gets preco.
     *
     * @return the preco
     */
    public int getPreco () {
        return preco;
    }

    @Override
    public String toString() {
        return  nome + "\nID: " + id +
                "\nStock: " + stock +
                "\nPreco: " + preco + "\n";
    }
}