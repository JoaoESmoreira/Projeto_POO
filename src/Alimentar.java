import java.io.Serializable;

/**
 * The type Food Product.
 */
public class Alimentar extends Produto implements Serializable {
    private int cal, fat;

    /**
     * Instantiates a new Food Product.
     */
    public Alimentar() {
    }

    /**
     * Instantiates a new Food Product.
     *
     * @param id    the id
     * @param stock the stock
     * @param preco the price
     * @param nome  the name
     * @param cal   the calories
     * @param fat   the fat percentage
     * @param promo the type of promotion
     */
    public Alimentar(int id, int stock, int preco, String nome, int cal, int fat, int promo) {
        super(id, stock, preco, nome, promo);
        this.cal = cal;
        this.fat = fat;
    }

    public int getPeso() {
        return -1;
    }

    /**
     * Gets calories.
     *
     * @return the calories
     */
    public int getCal() {
        return cal;
    }

    /**
     * Sets calories.
     *
     * @param cal the calories
     */
    public void setCal(int cal) {
        this.cal = cal;
    }

    /**
     * Gets fat percentage.
     *
     * @return the fat percentage
     */
    public int getFat() {
        return fat;
    }

    /**
     * Sets fat percentage.
     *
     * @param fat the fat percentage
     */
    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getPromo() {
        return super.getPromo();
    }

    public void setPromo(int promo) {
        super.setPromo(promo);
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

    public String print () {
        return  nome + "\nID: " + id +
                "\nPreco: " + preco + "\n" +
                "Calorias: " + cal +
                "\nGordura: " + fat + "\n";
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Calorias: " + cal +
                "\nGordura: " + fat + "\n";
    }
}