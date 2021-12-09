import java.io.*;
import java.util.ArrayList;

public class LerFicheiroObjetos {
    private ArrayList<Vendas> venda;
    private String titulo;

    public LerFicheiroObjetos() {
        venda = new ArrayList<>();
    }

    public LerFicheiroObjetos(String titulo) {
        venda = new ArrayList<>();
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

    public void addVendas(Vendas vendas) {
        this.venda.add(vendas);
    }

    public void soQueroLerUm () {
        File f = new File(titulo);

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Vendas vendas;
            while ((vendas = (Vendas) ois.readObject()) != null) {
                // vendas = (Vendas) ois.readObject();
                addVendas(vendas);

            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void escrita2 () {

        for (Vendas vendas : venda) {

            File f = new File(vendas.getCliente().getNome());

            try {
                FileOutputStream fos = new FileOutputStream(f, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(vendas);

                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printTexto() {
        for (Vendas vendas : venda) {
            System.out.println("Voce ja comprou :");
            vendas.printListaCompras();
            System.out.println("\n\n Já gastou: " + vendas.getCusto());
        }
    }
}
