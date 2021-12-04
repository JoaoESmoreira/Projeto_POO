import java.io.Serializable;

public class Alimentar extends Produto implements Promocao, Serializable {
    private int cal, fat;

    public Alimentar() {
    }

    public Alimentar(int id, int stock, int preco, String nome, int cal, int fat, int promo) {
        super(id, stock, preco, nome, promo);
        this.cal = cal;
        this.fat = fat;
    }

    @Override
    public int leve4pague3(int q, Produto p) {
        return (q - (q / 4)) * p.getPreco();
    }

    @Override
    public int pagueMenos(int q, Produto p) { //Verificar se é carrinho ou só compra
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