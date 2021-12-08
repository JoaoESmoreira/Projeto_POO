import java.io.Serializable;

public class Limpeza extends Produto implements Serializable {
    private int tox;

    public Limpeza() {
    }

    public Limpeza(int id, int stock, int preco, String nome, int tox, int promo) {
        super(id, stock, preco, nome, promo);
        this.tox = tox;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public int getTox() {
        return tox;
    }

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