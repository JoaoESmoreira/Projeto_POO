import java.io.Serializable;

public class Alimentar extends Produto implements Serializable {
    private int cal, fat;

    public Alimentar() {
    }

    public Alimentar(int id, int stock, int preco, String nome, int cal, int fat, int promo) {
        super(id, stock, preco, nome, promo);
        this.cal = cal;
        this.fat = fat;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public int getFat() {
        return fat;
    }

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

    @Override
    public String toString() {
        return  super.toString() +
                "Calorias: " + cal +
                "\nGordura: " + fat + "\n";
    }
}