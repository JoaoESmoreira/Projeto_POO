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
        ArrayList<Produto> stock = new ArrayList<>();
        Armazem armazem = new Armazem(stock);

        leituraClientes();
        // TODO leitura dos produtos
        armazem.addStock("inventario.txt");

        Cliente clienteOnline = login();
        Vendas historico = new Vendas();
        historico.setCliente(clienteOnline);

        int option;
        Scanner sn = new Scanner(System.in);

        int cart = 0;
        int delivery = 0;

        ArrayList<Produto> carrinho = new ArrayList<>();

        do {
            menu(cart, delivery);
            option = sn.nextInt();

            switch (option) {
                case 1 -> {
                    // TODO efetuar compras
                    armazem.printArmazem();
                    System.out.print("Insira o ID: ");
                    int id = sn.nextInt();
                    for (Produto p : stock) {
                        if (p.getId() == id) {
                            System.out.print("Qual a quantidade desejada? ");
                            int q = sn.nextInt();
                            while (q > p.getStock()) {
                                System.out.println("De momento não possuímos esse stock. :(");
                                System.out.print("Qual a quantidade desejada? ");
                                q = sn.nextInt();
                            }

                            p.setStock(p.getStock() - q); //A entrega nao pode estar sempre a acumular
                            System.out.println("Done :)\n");

                            for(int i = 0; i < q; i++){
                                carrinho.add(p);
                            }

                            for(Produto produto: carrinho){ // TODO DESCONTOS verificar tudo
                                switch (produto.getPromo()){
                                    case 0 -> {
                                        cart += produto.getPreco();
                                    }
                                }
                            }

                            /*
                            if (cart > 40 && clienteOnline.getFrequente()) {
                                delivery = 0;
                            } else if (cart <= 40 && clienteOnline.getFrequente()) {
                                delivery += 15;
                            } else {
                                delivery += 20;
                            }*/

                        }
                    }
                }
                case 2 -> {
                    // TODO listar historico de compras
                    LeituraFicheiros ficheiroHistorico = new LeituraFicheiros();
                    ficheiroHistorico.setTitulo(historico.getCliente().getNome() + ".txt");
                    ficheiroHistorico.leitura();
                    ficheiroHistorico.printTexto();
                }
            }
        } while (option != 0);

        for (Cliente c : clientes)
            System.out.println(c);

        armazem.printArmazem();

    }
}