public class Limpeza extends Produto{
    private int tox;

    public Limpeza(){}

    public int getTox() {
        return tox;
    }

    public void setTox(int tox) {
        this.tox = tox;
    }

    @Override
    public String toString() {
        return "Limpeza{" +
                super.toString() +
                "tox=" + tox +
                '}';
    }
}
