import java.io.Serializable;

/**
 * The type Dimensao.
 */
public class Dimensao implements Serializable {
    private int altura;
    private int largura;
    private int profundidade;

    /**
     * Instantiates a new Dimensao.
     */
    public Dimensao () {}

    /**
     * Instantiates a new Dimensao.
     *
     * @param altura       the altura
     * @param largura      the largura
     * @param profundidade the profundidade
     */
    public Dimensao (int altura, int largura, int profundidade) {
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    /**
     * Gets altura.
     *
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Sets altura.
     *
     * @param altura the altura
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Gets largura.
     *
     * @return the largura
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Sets largura.
     *
     * @param largura the largura
     */
    public void setLargura(int largura) {
        this.largura = largura;
    }

    /**
     * Gets profundidade.
     *
     * @return the profundidade
     */
    public int getProfundidade() {
        return profundidade;
    }

    /**
     * Sets profundidade.
     *
     * @param profundidade the profundidade
     */
    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public String toString () {
        return altura + " X " + largura + " X " + profundidade;
    }
}