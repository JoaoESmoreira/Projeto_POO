import java.util.ArrayList;

public class Vendas {
    private ArrayList<Produto> listaCompras;
    private Cliente            cliente;
    private int                custo;

    public ArrayList<Produto> getListaCompras() {
        return listaCompras;
    }
    public void setListaCompras(ArrayList<Produto> listaCompras) {
        this.listaCompras = listaCompras;
    }
    public void addProdutoNaListaCompras (Produto produto) {
        this.listaCompras.add(produto);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public String toString() {
        return  "listaCompras: " + listaCompras + ", cliente" + cliente + ", custo=" + custo;
    }
}
