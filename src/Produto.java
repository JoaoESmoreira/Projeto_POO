public class Produto {
    protected int id, stock;
    protected String nome;

    public Produto(){}

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

    @Override
    public String toString() {
        return "id=" + id +
                ", stock=" + stock +
                ", nome='" + nome + '\'' +
                '}';
    }
}
