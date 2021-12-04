import java.io.*;
import java.util.ArrayList;

public class LerFicheiroObjetos {
    private ArrayList<Vendas> venda;
    private String            titulo;

    public LerFicheiroObjetos () {
        venda = new ArrayList<>();
    }
    public LerFicheiroObjetos (String titulo) {
        venda      = new ArrayList<>();
        this.titulo = titulo;
    }

    public ArrayList<Vendas> getVenda() {
        return venda;
    }
    public void setVendas(ArrayList<Vendas> vendas) {
        this.venda = vendas;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void addVendas (Vendas vendas) {
        this.venda.add(vendas);
    }

    public void leitura () {
        File f = new File(titulo);

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Vendas venda;
            do {
                venda = (Vendas) ois.readObject();

                if (venda != null)
                    addVendas(venda);

            } while (venda != null);

            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printTexto () {
        for (Vendas vendas : venda) {
            System.out.println("Voce ja comprou :");
            vendas.printListaCompras();
            System.out.println("\n\n Já gastou: " + vendas.getCusto());
        }
    }
}
