import java.io.*;
import java.util.ArrayList;

public class LerFicheiroObjetos {
    private ArrayList<Produto> produtos;
    private String            titulo;

    public LerFicheiroObjetos () {
        produtos = new ArrayList<>();
    }
    public LerFicheiroObjetos (String titulo) {
        produtos    = new ArrayList<>();
        this.titulo = titulo;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void addProduto (Produto produto) {
        produtos.add(produto);
    }

    public void leitura () {
        File f = new File(titulo);

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Produto p;
            do {
                p = (Produto) ois.readObject();
                if (p != null)
                    produtos.add(p);
            } while (p != null);

            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
