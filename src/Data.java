public class Data {
    protected int ano, mes, dia;

    public Data() {
    }

    public Data(int a, int m, int d) {
        ano = a;
        mes = m;
        dia = d;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return dia + " do " + mes + " de " + ano;
    }
}
