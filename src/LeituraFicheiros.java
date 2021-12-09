import java.io.*;
import java.util.ArrayList;

/**
 * The type Leitura ficheiros.
 */
public class LeituraFicheiros {
    private ArrayList<String> lines;
    private String            titulo;

    /**
     * Instantiates a new Leitura ficheiros.
     */
    public LeituraFicheiros () {}

    /**
     * Gets lines.
     *
     * @return the lines
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
     * Leitura.
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
     * Gets titulo.
     *
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets titulo.
     *
     * @param titulo the titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Print texto.
     */
    public void printTexto () {
        for (String linhas : lines) {
            System.out.println(linhas);
        }
    }
}
