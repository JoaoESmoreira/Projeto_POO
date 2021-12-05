import java.util.ArrayList;

public class Vendas {
    private ArrayList<Produto> listaCompras;
    private Cliente            cliente;
    private int                custo;

    public Vendas () {
        this.listaCompras = new ArrayList<>();
    }

    public ArrayList<Produto> getListaCompras() {
        return listaCompras;
    }
    public void setListaCompras(ArrayList<Produto> listaCompras) {
        this.listaCompras = listaCompras;
    }
    public void addProdutoNaListaCompras (Produto produto) {
        listaCompras.add(produto);
        setCusto();
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

    public int jaTeveDesconto (Produto produto, int pos) {
        int flag = 0;

        for (int i = 0; i < pos; ++i) {
            if (produto.getNome().equals(listaCompras.get(i).getNome()))
                flag++;
        }
        return flag;
    }

    public int quantosNaLista (Produto produto) {
        int count = 0;

        for (Produto p : listaCompras) {
            if (p.getNome().equals(produto.getNome()))
                count++;
        }
        return count;
    }

    public void setCusto() {
        int custo = 0;

        for (int i = 0; i < listaCompras.size(); ++i) {
            if (listaCompras.get(i).getPromo() == 0) {
                custo += listaCompras.get(i).getPreco();

            } else if (listaCompras.get(i).getPromo() == 1) {
                int descontoPercent = jaTeveDesconto(listaCompras.get(i), i);
                if (descontoPercent <= 10) {
                    custo += listaCompras.get(i).getPreco() * (1 - (descontoPercent * 0.05));
                } else {
                    custo += listaCompras.get(i).getPreco() * 0.5;
                }
            }else if (listaCompras.get(i).getPromo() == 2) {
                if (jaTeveDesconto(listaCompras.get(i), i) == 0) {
                    int totalPagar = quantosNaLista(listaCompras.get(i)) - (quantosNaLista(listaCompras.get(i)) / 4);
                    custo +=  listaCompras.get(i).getPreco() * totalPagar;
                }
            }
        }
        // TODO falta verificar se os decontos estao bem
        this.custo = custo;
    }

    public void printListaCompras () {
        for (Produto produto : listaCompras)
            System.out.print(produto.getNome() + " / " + produto.getPreco() + "€\n");
    }
}