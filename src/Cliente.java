public class Cliente {
    private String nome, morada, email;
    private int telefone;
    private Data dataNascimento;
    private Boolean loggedIn = false;
    private Boolean frequente = false;

    public Cliente () {}

    public Cliente(String nome, String morada, String email, int telefone, Data dataNascimento, int n) {
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.telefone = telefone;
        if (n == 1) {
            frequente = true;
        }
    }

    public Boolean getFrequente() {
        return frequente;
    }

    public void setFrequente(Boolean frequente) {
        this.frequente = frequente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "Cliente:\n" +
                "nome: " + nome + '\n' +
                "morada: " + morada + '\n' +
                "email: " + email + '\n' +
                "telefone: " + telefone + '\n' +
                "dataNascimento: " + dataNascimento + '\n' +
                "cliente Frequente: " + frequente + '\n';
    }
}