import java.io.Serializable;

/**
 * The type Cliente.
 */
public class Cliente extends LerFicheiroObjetos implements Serializable {
    private String nome, morada, email;
    private int telefone;
    private Data dataNascimento;
    private Boolean loggedIn = false;
    private Boolean frequente = false;

    /**
     * Instantiates a new Cliente.
     */
    public Cliente () {}

    /**
     * Instantiates a new Cliente.
     *
     * @param nome           the nome
     * @param morada         the morada
     * @param email          the email
     * @param telefone       the telefone
     * @param dataNascimento the data nascimento
     * @param n              the n
     */
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

    /**
     * Gets frequente.
     *
     * @return the frequente
     */
    public Boolean getFrequente() {
        return frequente;
    }

    /**
     * Sets frequente.
     *
     * @param frequente the frequente
     */
    public void setFrequente(Boolean frequente) {
        this.frequente = frequente;
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets morada.
     *
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Sets morada.
     *
     * @param morada the morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets telefone.
     *
     * @return the telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * Sets telefone.
     *
     * @param telefone the telefone
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * Gets data nascimento.
     *
     * @return the data nascimento
     */
    public Data getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets data nascimento.
     *
     * @param dataNascimento the data nascimento
     */
    public void setDataNascimento(Data dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Gets logged in.
     *
     * @return the logged in
     */
    public Boolean getLoggedIn() {
        return loggedIn;
    }

    /**
     * Sets logged in.
     *
     * @param loggedIn the logged in
     */
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