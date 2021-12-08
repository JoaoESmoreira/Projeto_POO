import java.io.Serializable;

public class Produto implements Serializable {
    protected int id, stock, preco, promo;
    protected String nome, tipo;

    public Produto(){}

    public Produto(String tipo, int id, int stock, int preco, String nome, int promo) {
        this.tipo = tipo;
        this.id = id;
        this.stock = stock;
        this.preco = preco;
        this.nome = nome;
        this.promo = promo;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco (int preco) {
        this.preco = preco;
    }

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