import java.io.Serializable;

/**
 * The type Product.
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
     * Instantiates a new Product.
     */
    public Produto(){}

    /**
     * Instantiates a new Product.
     *
     * @param id    the id
     * @param stock the stock
     * @param preco the price
     * @param nome  the name
     * @param promo the promotion
     */
    public Produto(int id, int stock, int preco, String nome, int promo) {
        this.id = id;
        this.stock = stock;
        this.preco = preco;
        this.nome = nome;
        this.promo = promo;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public abstract int getPeso();

    /**
     * Gets promotion.
     *
     * @return the promotion
     */
    public int getPromo() {
        return promo;
    }

    /**
     * Sets promotion.
     *
     * @param promo the promotion
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
     * Gets name.
     *
     * @return the name
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets name.
     *
     * @param nome the name
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Sets price.
     *
     * @param preco the price
     */
    public void setPreco (int preco) {
        this.preco = preco;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPreco () {
        return preco;
    }

    abstract String print ();

    @Override
    public String toString() {
        return  nome + "\nID: " + id +
                "\nStock: " + stock +
                "\nPreco: " + preco + "\n";
    }
}