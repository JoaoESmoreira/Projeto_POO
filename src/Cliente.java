import java.io.Serializable;

/**
 * The type Client.
 */
public class Cliente extends LerFicheiroObjetos implements Serializable {
    private String nome, morada, email;
    private int telefone;
    private Data dataNascimento;
    private Boolean loggedIn = false;
    private Boolean frequente = false;

    /**
     * Instantiates a new Client.
     */
    public Cliente () {}

    /**
     * Instantiates a new Client.
     *
     * @param nome           the name
     * @param morada         the address
     * @param email          the email
     * @param telefone       the phoneNumber
     * @param dataNascimento the birthday
     * @param n              the frequency
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
     * Gets frequency.
     *
     * @return the frequency
     */
    public Boolean getFrequente() {
        return frequente;
    }

    /**
     * Sets frequency.
     *
     * @param frequente the frequency
     */
    public void setFrequente(Boolean frequente) {
        this.frequente = frequente;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets name.
     *
     * @param nome the name
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getMorada() {
        return morada;
    }

    /**
     * Sets address.
     *
     * @param morada the address
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
     * Gets phoneNumber.
     *
     * @return the phoneNumber
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * Sets phoneNumber.
     *
     * @param telefone the phoneNumber
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public Data getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets birthday.
     *
     * @param dataNascimento the birthday
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