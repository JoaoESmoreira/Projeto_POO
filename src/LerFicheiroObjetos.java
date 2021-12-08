import javax.swing.plaf.ProgressBarUI;
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

    /*
    public void soQueroLerUm () {
        File f = new File(titulo);

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Vendas venda = (Vendas) ois.readObject();
            addVendas(venda);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void leituraAntigo() {
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

    public void leitura(Cliente c) {
        Produto p = null;
        boolean ver = true;
        while (ver) {
            try {
                FileInputStream fileInputStream = new FileInputStream(c.getNome() + ".txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                p = (Produto) objectInputStream.readObject();

                if(p != null){
                    System.out.println(p);
                }
                else{
                    ver = false;
                }

                System.out.println("Sucesso");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro na leitura FO :(");
            }
        }
    }

    public void escrita(Cliente c, Produto produto, int q) {
        try {
            FileOutputStream outFile = new FileOutputStream(c.getNome() + ".txt");
            ObjectOutputStream outStream = new ObjectOutputStream(outFile);

            //for(int i = 0; i < q; i++)
            outStream.writeObject(produto);

            outStream.close();
            outFile.close();

        } catch (IOException e) {
            System.out.println("Erro escrita FO :(");
        }
    }*/

    public void escrita2 () {

        for (Vendas vendas : venda) {

            File f = new File(vendas.getCliente().getNome() + ".obj");

            try {
                FileOutputStream fos = new FileOutputStream(f);
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
            vendas.printListaCompras();
            System.out.println("\nTotal: " + vendas.getCusto() + "€\n");
        }
    }
}
