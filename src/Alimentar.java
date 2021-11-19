public class Alimentar extends Produto{
    private int cal, fat;

    public Alimentar(){}

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        return "Alimentar{" +
                super.toString() +
                "cal=" + cal +
                ", fat=" + fat +
                '}';
    }
}
