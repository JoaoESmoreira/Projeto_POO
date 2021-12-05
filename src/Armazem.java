import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Armazem {
    private ArrayList<Produto> armazem;

    public Armazem () {
        this.armazem = new ArrayList<>();
    }

    public Armazem (ArrayList<Produto> armazem) {
        this.armazem = armazem;
    }

    public ArrayList<Produto> getArmazem() {
        return armazem;
    }

    public void setArmazem(ArrayList<Produto> armazem) {
        this.armazem = armazem;
    }

    public void addStock(String file) {
        LeituraFicheiros ficheiro = new LeituraFicheiros();
        ficheiro.setTitulo(file);
        ficheiro.leitura();

        ArrayList<String> linhas = ficheiro.getLines();

        for (String s : linhas) {
            String[] dados = s.split(",");

            String t = dados[0];

            if (Objects.equals(t, "a")) {
                armazem.add(new Alimentar(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), dados[6], Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[7])));
            } else if (t.equals("l")) {
                armazem.add(new Limpeza(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), dados[5], Integer.parseInt(dados[4]), Integer.parseInt(dados[6])));
            } else if (t.equals("m")) {
                String[] dim = dados[5].split("/");
                Dimensao d = new Dimensao(Integer.parseInt(dim[0]), Integer.parseInt(dim[1]), Integer.parseInt(dim[2]));
                armazem.add(new Mobiliario(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), dados[6], Integer.parseInt(dados[4]), d, Integer.parseInt(dados[7])));
            }
        }
    }

    public Produto produtoNoArmazem (int id) {
        Produto flag = null;
        for (Produto produto : armazem) {
            if (produto.getId() == id)
                flag = produto;
        }
        return flag;
    }


    public void printArmazem() {
        for (Produto p : armazem) {
            System.out.println(p);
        }
    }
}
