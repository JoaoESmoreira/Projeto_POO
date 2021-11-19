public class Mobiliario extends Produto{
    private int peso, dim;

    public Mobiliario(){}

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
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
