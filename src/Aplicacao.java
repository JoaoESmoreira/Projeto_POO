import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    static ArrayList<Cliente> clientes = new ArrayList<>();

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

    // o que eu fiz, da a possibilidade de o utilizador errar o email
    public static Cliente verificaLogin(String email) {
        Cliente flag = null;

        // percebo perfeitamente que o programa nao está otimizado, mas respeita as boas praticas: ALGO QUE A PROF GOSTA
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email)) {
                flag = c;
                c.setLoggedIn(true);
                System.out.println("Bem vind@, " + c.getNome() + "!");
            }
        }
        return flag;
    }

    public static Cliente login() {
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

    static void menu(int val, int del) {
        System.out.println("Introduza: 0 - para fazer logout\n" +
                "Introduza: 1 - para efetuar uma compra\n" +
                "Introduza: 2 - para ver o seu histórico de compras\n\n" +
                "Valor do carrinho: " + val + "€\n" +
                "Custo da entrega: " + del + "€\n");
    }
    // TODO ___________________________________MAIN_______________________________________________
    public static void main(String[] args) {
        leituraClientes();
        Cliente clienteOnline = login();

        Armazem armazem       = new Armazem();
        Vendas historicoVenda = new Vendas();

        historicoVenda.setCliente(clienteOnline);
        armazem.addStock("inventario.txt");

        int cart = 0;
        int delivery = 0;

        int option;
        Scanner sn = new Scanner(System.in);

        do {
            menu(cart, delivery);
            option = sn.nextInt();

            switch (option) {
                case 1 : {
                    // TODO efetuar compras
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

                    } else {
                        System.out.println("Nao exite produtos com esse ID");
                    }
                    // TODO escrever o hitorico num ficheiro de objetos
                    break;
                }
                case 2 : {
                    // TODO listar historico de compras
                    LerFicheiroObjetos ficheiroHistorico = new LerFicheiroObjetos();
                    //ficheiroHistorico.setTitulo(historico.getCliente().getNome() + ".txt");
                    ficheiroHistorico.setTitulo("Francisco.txt");
                    ficheiroHistorico.leituraAntigo();
                    ficheiroHistorico.printTexto();

                    break;
                } default:
                    System.out.println("Operaçao invalida");
                    break;
            }
        } while (option != 0);

        LerFicheiroObjetos escreve = new LerFicheiroObjetos();
        escreve.setTitulo("Francisco.obj");
        escreve.escrita2(historicoVenda);
        escreve.leituraAntigo();


        }
}