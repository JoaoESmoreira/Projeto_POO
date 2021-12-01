import java.io.*;
import java.util.ArrayList;

public class Armazem{
    private ArrayList<Produto> armazem;

    public Armazem(ArrayList<Produto> armazem) {
        this.armazem = armazem;
    }

    public void addStock(File file) {
        try {
            fileRead(file);
        } catch (IOException e) {
            System.out.println("Erro em addStock :/");
        }
    }

    void fileRead(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] dados = line.split(",");
            armazem.add(new Produto(Integer.parseInt(dados[0]),Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), dados[3]));
        }

        bufferedReader.close();
    }

    public void printArmazem(){
        for(Produto p: armazem){
            System.out.println(p);
        }
    }
}
