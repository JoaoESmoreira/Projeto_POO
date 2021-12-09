import java.io.*;
import java.util.ArrayList;

/**
 * The type File Reading and Writing.
 */
public class LeituraFicheiros {
    private ArrayList<String> lines;
    private String            titulo;

    /**
     * Instantiates a new File Reading.
     */
    public LeituraFicheiros () {}

    /**
     * Gets lines.
     *
     * @return the lines in an ArrayList
     */
    public ArrayList<String> getLines() {
        return lines;
    }

    /**
     * Sets lines.
     *
     * @param lines the lines
     */
    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets title.
     *
     * @param titulo the title
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Leitura.
     *
     * Read the file line by line, and add it to an ArrayList
     */
    public void leitura() {
        ArrayList<String> texto = new ArrayList<>();
        File file = new File(titulo);

        try {
            FileReader fR     = new FileReader(file);
            BufferedReader bR = new BufferedReader(fR);
            String line;

            do {
                line = bR.readLine();

                if (line != null)
                    texto.add(line);

            } while (line != null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        setLines(texto);
    }


    /**
     * Invoice
     *
     * Write a invoice in a text file
     *
     * @param vendas the purchase object
     * @param c      the client object
     */
    public void fatura(Vendas vendas, Cliente c) {
        try {
            int cart = 0;
            FileWriter fileWriter = new FileWriter("Faturas" + c.getNome() + ".txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("---------------------- FATURA ----------------------\n");

            for(Produto p: vendas.getListaCompras()) {
                cart += p.getPreco();
                bufferedWriter.write(p.print());
                bufferedWriter.write('\n');
            }

            bufferedWriter.write("Total da compra: " + cart + "€\n");

            bufferedWriter.close();
        }
        catch (IOException e){
            System.out.println("Erro no fileWrite :(");
            e.printStackTrace();
        }
    }

    /**
     * Print text.
     *
     * Print the ArrayList that contain all lines of text read before
     */
    public void printTexto () {
        for (String linhas : lines) {
            System.out.println(linhas);
        }
    }
}
