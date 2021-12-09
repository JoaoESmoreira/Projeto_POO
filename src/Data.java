import java.io.Serializable;

/**
 * The type Data.
 */
public class Data implements Serializable {
    /**
     * The Ano.
     */
    protected int ano, /**
     * The Mes.
     */
    mes, /**
     * The Dia.
     */
    dia;

    /**
     * Instantiates a new Data.
     */
    public Data() {
    }

    /**
     * Instantiates a new Data.
     *
     * @param a the a
     * @param m the m
     * @param d the d
     */
    public Data(int a, int m, int d) {
        ano = a;
        mes = m;
        dia = d;
    }

    /**
     * Gets ano.
     *
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * Sets ano.
     *
     * @param ano the ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Gets mes.
     *
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * Sets mes.
     *
     * @param mes the mes
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Gets dia.
     *
     * @return the dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * Sets dia.
     *
     * @param dia the dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return dia + " do " + mes + " de " + ano;
    }
}