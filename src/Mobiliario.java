public class Mobiliario extends Produto implements Promocao{
    private int peso;
    private Dimensao dim;

    public Mobiliario(){}

    public Mobiliario(int id, int stock, int preco, String nome, int peso, Dimensao dim, int promo) {
        super(id, stock, preco, nome, promo);
        this.peso = peso;
        this.dim = dim;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    @Override
    public int leve4pague3(int q, Produto p) {
        return (q - (q / 4)) * p.getPreco();
    }

    @Override
    public int pagueMenos(int q, Produto p) {
        float cost = 0;
        float per = 1;
        for(int i = 0; i < q; i++){
            cost += p.getPreco()*per;
            if(per >= 0.5){
                per -= 0.05;
            }
        }
        return (int) cost;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Dimensao getDim() {
        return dim;
    }

    public void setDim(Dimensao dim) {
        this.dim = dim;
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
        return "Mobiliario{" +
                super.toString() +
                "peso=" + peso +
                ", dim=" + dim +
                '}';
    }
}