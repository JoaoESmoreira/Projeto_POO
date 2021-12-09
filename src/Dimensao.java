import java.io.Serializable;

/**
 * The type Dimension.
 */
public class Dimensao implements Serializable {
    private int altura;
    private int largura;
    private int profundidade;

    /**
     * Instantiates a new Dimension.
     */
    public Dimensao () {}

    /**
     * Instantiates a new Dimension.
     *
     * @param altura       the height
     * @param largura      the width
     * @param profundidade the profundity
     */
    public Dimensao (int altura, int largura, int profundidade) {
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Sets height.
     *
     * @param altura the height
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Sets width.
     *
     * @param largura the width
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * Gets profundity.
     *
     * @return the profundity
     */
    public int getProfundidade() {
        return profundidade;
    }

    /**
     * Sets profundity.
     *
     * @param profundidade the profundity
     */
    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public String toString () {
        return altura + " X " + largura + " X " + profundidade;
    }
}