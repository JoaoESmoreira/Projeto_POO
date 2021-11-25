import java.io.*;
import java.util.ArrayList;

public class LeituraFicheiros {
    private ArrayList<String> lines;
    private String            titulo;

    public LeituraFicheiros () {}

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }

    public void leitura() {
        ArrayList<String> texto = new ArrayList<>();
        File file = new File(titulo);

        try {
            FileReader fR     = new FileReader(file);
            BufferedReader bR = new BufferedReader(fR);
            String line;

            while (true) {
                line = bR.readLine();

                if (line != null) {
                    texto.add(line);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLines(texto);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
