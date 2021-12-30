import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Sell/Purchase.
 */
public class Vendas implements Serializable {
    private ArrayList<Produto> listaCompras;
    private Cliente            cliente;
    private int                custo;

    /**
     * Instantiates a new Purchase.
     */
    public Vendas () {
        this.listaCompras = new ArrayList<>();
    }

    /**
     * Gets Purchase List.
     *
     * @return the purchase list (an ArrayList of Products)
     */
    public ArrayList<Produto> getListaCompras() {
        return listaCompras;
    }

    /**
     * Sets Purchase List.
     *
     * @param listaCompras the purchase list (an ArrayList of Products)
     */
    public void setListaCompras(ArrayList<Produto> listaCompras) {
        this.listaCompras = listaCompras;
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Sets client.
     *
     * @param cliente the client
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getCusto() {
        return custo;
    }

    /**
     * Sets Price Constructor.
     *
     * @param custo the price
     */
    public void setCustoConstrutor(int custo) {
        this.custo = custo;
    }

    /**
     * Add Product on Purchase List.
     *
     * @param produto the product
     */
    public void addProdutoNaListaCompras (Produto produto) {
        listaCompras.add(produto);
        setCusto();
    }

    /**
     * Already has discount.
     *
     * @param produto the product
     * @param pos     the position on arrayList
     *
     * @return the number of products already had discount until given position
     */
    public int jaTeveDesconto (Produto produto, int pos) {
        int flag = 0;

        for (int i = 0; i < pos; ++i) {
            if (produto.getNome().equals(listaCompras.get(i).getNome()))
                flag++;
        }
        return flag;
    }

    /**
     * How Many in List.
     *
     * @param produto the product
     * @return the number of products already on list
     */
    public int quantosNaLista (Produto produto) {
        int count = 0;

        for (Produto p : listaCompras) {
            if (p.getNome().equals(produto.getNome()))
                count++;
        }
        return count;
    }

    /**
     * Sets Final Price.
     */
    public void setCusto() {
        int custo = 0;

        for (int i = 0; i < listaCompras.size(); ++i) {
            if (listaCompras.get(i).getPromo() == 0) {
                // sem desconto
                custo += listaCompras.get(i).getPreco();

            } else if (listaCompras.get(i).getPromo() == 1) {
                // desconto em percentagem

                int descontoPercent = jaTeveDesconto(listaCompras.get(i), i);

                if (descontoPercent <= 10) {
                    custo += listaCompras.get(i).getPreco() * (1 - (descontoPercent * 0.05));
                } else {
                    custo += listaCompras.get(i).getPreco() * 0.5;
                }
            } else if (listaCompras.get(i).getPromo() == 2) {
                // desconto leve 4 pague 3
                if (jaTeveDesconto(listaCompras.get(i), i) == 0) {
                    int totalPagar = quantosNaLista(listaCompras.get(i)) - (quantosNaLista(listaCompras.get(i)) / 4);
                    custo +=  listaCompras.get(i).getPreco() * totalPagar;
                }
            }
        }
        // define custo
        this.custo = custo;
    }

    /**
     * Sets shipping costs.
     *
     * @param cliente the client
     * @return the shipping costs
     */
    public int setPortesEnvio (Cliente cliente) {
        int delivery;

        if (custo > 40 && cliente.getFrequente()){
            delivery = 0;
        } else if (custo <= 40 && cliente.getFrequente()) {
            delivery = 15;
        } else {
            delivery = 20;
        }

        for (Produto produto : listaCompras) {
            if (produto.getPeso() > 15)
                delivery += 10;
        }

        return delivery;
    }

    /**
     * Print shipping costs.
     */
    public void printListaCompras () {
        for (Produto produto : listaCompras)
            System.out.print(produto.getNome() + " / " + produto.getPreco() + "€\n");
    }
}