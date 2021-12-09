import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Aplication.
 *
 * This is the Main class where is the flow program.
 * It's possible make a purchase and list all purschases did before.
 */
public class Aplicacao {
    /**
     * The Clientes ArrayList.
     *
     * It's a global variable where we have Clients and its attirbutes.
     */
    static ArrayList<Cliente> clientes = new ArrayList<>();

    /**
     * Leitura clientes.
     *
     * We read a file with all Clients and its attirbutes.
     * In the end we add to global ArrayList.
     */
    static void leituraClientes() {
        LeituraFicheiros ficheiro = new LeituraFicheiros();
        ficheiro.setTitulo("Clientes.txt");
        ficheiro.leitura();

        ArrayList<String> leitura = ficheiro.getLines();

        for (String str : leitura) {
            String[] dados = str.split(",");

            // criar a data
            String[] data = dados[4].split("/");  // dei split da string original do ficheiro
            Data d = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));  // criei o objeto data e converti as strings em inteiros

            // adicionar o cliente à arraylist
            clientes.add(new Cliente(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]), d, Integer.parseInt(dados[5])));
        }
    }

    /**
     * Verify login client.
     *
     * Given email, if there is an email we log in and return the respective Client.
     *
     * @param email the email
     * @return the client
     */
    public static Cliente verificaLogin(String email) {
        Cliente flag = null;

        // verificar se o email existe
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email)) {
                // colocar o cliente online
                flag = c;
                c.setLoggedIn(true);
                System.out.println("Bem vind@, " + c.getNome() + "!");
            }
        }
        return flag;
    }

    /**
     * Login client.
     *
     * While the Cliente not logged in we ask for an email.
     * In the end, we will return the respective client.
     *
     * @return the client
     */
    public static Cliente login() {
        System.out.println("---------------------- LOGIN ----------------------");

        Scanner sn = new Scanner(System.in);
        Cliente verificacao;

        do {
            System.out.print("Introduza o endereco de email: ");
            String email = sn.nextLine();

            verificacao = verificaLogin(email);

            if (verificacao == null)
                System.out.println("Email nao verificado!");

        } while (verificacao == null);

        return verificacao;
    }

    /**
     * Menu.
     *
     * It's a simple menu. We have: - option of all operations that Client can do
     *                              - the value of purchase and delivery
     *
     * @param val the value
     * @param del the delivery
     */
    static void menu(int val, int del) {
        System.out.println("---------------------- MENU ----------------------\n");
        System.out.println("Introduza: 0 - para fazer logout\nIntroduza: 1 - para efetuar uma compra\n" +
                           "Introduza: 2 - para ver o seu histórico de compras\n" +
                           "\nValor do carrinho: " + val + "€\n" +
                           "Custo da entrega: " + del + "€\n");
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
// TODO ___________________________________MAIN_______________________________________________
    public static void main(String[] args) {
        // DONE fazer leitura dos clientes
        leituraClientes();
        Cliente clienteOnline = login();

        // DONE fazer a leitura do stock
        Armazem armazem = new Armazem();
        Vendas historicoVenda = new Vendas();

        historicoVenda.setCliente(clienteOnline);
        armazem.addStock("inventario.txt");

        int option;
        int delivery = 0;

        Scanner sn = new Scanner(System.in);

        do {
            menu(historicoVenda.getCusto(), delivery);
            option = sn.nextInt();

            switch (option) {
                case 0: {
                    // DONE log out
                    System.out.println("Logout!\n          Volte sempre!!");

                    // custo final = delivery + custo dos produtos
                    historicoVenda.setCustoConstrutor(historicoVenda.getCusto() + delivery);

                    // DONE escrever a lista de compras no ficheiro
                    LerFicheiroObjetos escreve = new LerFicheiroObjetos();
                    escreve.setTitulo(clienteOnline.getNome() + ".obj");
                    escreve.addVendas(historicoVenda);
                    escreve.escrita();

                    LeituraFicheiros ficheiro = new LeituraFicheiros();
                    ficheiro.fatura(historicoVenda, clienteOnline);

                    break;
                }
                case 1: {
                    // DONE efetuar compras
                    armazem.printArmazem();
                    System.out.print("Insira o ID: ");

                    int id = sn.nextInt();
                    Produto produtoDesejado = armazem.produtoNoArmazem(id);

                    if (produtoDesejado != null) {

                        int quantidade;
                        do {
                            System.out.print("Qual a quantidade desejada? ");
                            quantidade = sn.nextInt();

                        } while (quantidade > produtoDesejado.getStock());

                        produtoDesejado.setStock(produtoDesejado.getStock() - quantidade);

                        for (int i = 0; i < quantidade; ++i) {
                            historicoVenda.addProdutoNaListaCompras(produtoDesejado);
                        }

                        delivery = historicoVenda.setPortesEnvio(clienteOnline);

                    } else {
                        System.out.println("Nao exite produtos com esse ID");
                    }

                    break;
                }
                case 2: {
                    // DONE listar historico de compras

                    LerFicheiroObjetos ficheiroHistorico = new LerFicheiroObjetos();
                    ficheiroHistorico.setTitulo(clienteOnline.getNome() + ".obj");
                    ficheiroHistorico.soQueroLerUm();
                    ficheiroHistorico.printTexto();

                    break;
                }
                default:
                    System.out.println("Operaçao invalida");
                    break;
            }
        } while (option != 0);
    }
}
