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
        setCusto(); // TODO será que isto é correto?
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

    public void setCusto() {
        int custo = 0;
        for (Produto produto : listaCompras) {
            custo += produto.preco;
        }

        // TODO falta adicionar o desconto final
        this.custo = custo;
    }

    public void printListaCompras () {
        for (Produto produto : listaCompras)
            System.out.print(produto + " / ");
    }

    public String toString() {
        return  "listaCompras: " + listaCompras + ", cliente" + cliente + ", custo=" + custo;
    }
}