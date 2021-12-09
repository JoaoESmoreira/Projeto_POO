import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Vendas.
 */
public class Vendas implements Serializable {
    private ArrayList<Produto> listaCompras;
    private Cliente            cliente;
    private int                custo;

    /**
     * Instantiates a new Vendas.
     */
    public Vendas () {
        this.listaCompras = new ArrayList<>();
    }


    /**
     * Gets lista compras.
     *
     * @return the lista compras
     */
    public ArrayList<Produto> getListaCompras() {
        return listaCompras;
    }

    /**
     * Sets lista compras.
     *
     * @param listaCompras the lista compras
     */
    public void setListaCompras(ArrayList<Produto> listaCompras) {
        this.listaCompras = listaCompras;
    }

    /**
     * Add produto na lista compras.
     *
     * @param produto the produto
     */
    public void addProdutoNaListaCompras (Produto produto) {
        listaCompras.add(produto);
        setCusto();
    }

    /**
     * Gets cliente.
     *
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Sets cliente.
     *
     * @param cliente the cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Gets custo.
     *
     * @return the custo
     */
    public int getCusto() {
        return custo;
    }

    /**
     * Sets custo construtor.
     *
     * @param custo the custo
     */
    public void setCustoConstrutor(int custo) {
        this.custo = custo;
    }

    /**
     * Ja teve desconto int.
     *
     * @param produto the produto
     * @param pos     the pos
     * @return the int
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
     * Quantos na lista int.
     *
     * @param produto the produto
     * @return the int
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
     * Sets custo.
     */
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

    /**
     * Sets portes envio.
     *
     * @param cliente the cliente
     * @return the portes envio
     */
    public int setPortesEnvio (Cliente cliente) {
        int delivery;

        if (custo > 40 && cliente.getFrequente()){
            delivery = 0;
        } else if (custo <= 40 && cliente.getFrequente()){
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
     * Print lista compras.
     */
    public void printListaCompras () {
        for (Produto produto : listaCompras)
            System.out.print(produto.getNome() + " / " + produto.getPreco() + "€\n");
    }
}