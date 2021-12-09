import java.io.Serializable;

/**
 * The type Data.
 */
public class Data implements Serializable {
    /**
     * The Year.
     */
    protected int ano, /**
     * The Month.
     */
    mes, /**
     * The Day.
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
     * @param a the year
     * @param m the month
     * @param d the day
     */
    public Data(int a, int m, int d) {
        ano = a;
        mes = m;
        dia = d;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getAno() {
        return ano;
    }

    /**
     * Sets year.
     *
     * @param ano the year
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public int getMes() {
        return mes;
    }

    /**
     * Sets month.
     *
     * @param mes the month
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Gets day.
     *
     * @return the day
     */
    public int getDia() {
        return dia;
    }

    /**
     * Sets day.
     *
     * @param dia the day
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return dia + " do " + mes + " de " + ano;
    }
}