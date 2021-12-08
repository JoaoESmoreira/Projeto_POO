import java.io.Serializable;

public class Limpeza extends Produto implements Promocao, Serializable {
    private int tox;

    public Limpeza() {
    }

    public Limpeza(String tipo, int id, int stock, int preco, String nome, int tox, int promo) {
        super(tipo, id, stock, preco, nome, promo);
        this.tox = tox;
    }

    @Override
    public int leve4pague3(int q, Produto p) {
        return (q - (q / 4)) * p.getPreco();
    }

    @Override
    public int pagueMenos(int q, Produto p) {
        float cost = 0;
        float per = 1;
        for (int i = 0; i < q; i++) {
            cost += p.getPreco() * per;
            if (per >= 0.5) {
                per -= 0.05;
            }
        }
        return (int) cost;
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