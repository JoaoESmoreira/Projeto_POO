import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void adicionaClientes(){
        clientes.add(new Cliente("Francisco", "Coimbra", "fmacedo@student.uc.pt", 969715348, new Data(2002,3, 10)));
        clientes.add(new Cliente("Manuel", "Lisboa", "manuel.mail@gmail.com", 915473877, new Data(1992, 5, 16)));
        clientes.add(new Cliente("Joana", "Porto", "joana.mail@hotmail.com", 924106841, new Data(1989, 10, 3)));
    }

    static void leituraClientes () {
        try {
            FileReader file   = new FileReader("Clientes.txt");
            BufferedReader bf = new BufferedReader(file);
            String line;

            while (true) {
                line = bf.readLine();

                if (line != null) {
                    String[] dados = line.split(",");

                    // criar a data
                    String[] data =  dados[4].split("/");  // dei split da string original do ficheiro
                    Data d        = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));  // criei o objeto data e converti as strings em inteiros

                    // adicionar o cliente à arraylist
                    clientes.add(new Cliente(dados[0], dados[1], dados[2], Integer.parseInt(dados[3]), d));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
        }
    }

    // o que eu fiz, da a possibilidade de o utilizador errar o email
    // TODO melhorar a funco: - a funçao devolve o objeto do respetivo cliente, isto porque depois é so procurar os respetivos ficheiros do cliente para o comportamento do programa
    public static boolean verificaLogin (String email) {
        boolean flag = false;

        // percebo perfeitamente que o programa nao está otimizado, mas respeita as boas praticas: ALGO QUE A PROF GOSTA
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email)) {
                flag = true;
                c.setLoggedIn(true);
                System.out.println("Bem vind@, " + c.getNome() + "!");
            }
        }
        return flag;
    }

    public static void login1 () {
        Scanner sn = new Scanner(System.in);
        boolean verificacao;

        do {
            System.out.print("Introduza o endereco de email: ");
            String email = sn.nextLine();

            verificacao  = verificaLogin(email);

            if (!verificacao)
                System.out.println("Email nao verificado!");

        } while (!verificacao);

    }

    static void menu () {
        System.out.println("Introduza: 0 - para fazer logout\n" +
                           "Introduza: 1 - para efetuar uma compra\n" +
                           "Introduza: 2 - para ver o seu histórico de compras\n");
    }


    // TODO ___________________________________MAIN_______________________________________________
    public static void main(String[] args){
        adicionaClientes();
        leituraClientes();
        login1();

        int option;
        Scanner sn = new Scanner(System.in);

        do {
            menu();
            option = sn.nextInt();

            switch (option) {
                case 1:
                    // TODO efetuar compras
                    break;
                case 2:
                    // TODO listar historico de compras
                    break;
            }
        } while (option != 0);

        for (Cliente c : clientes)
            System.out.println(c);

    }
}
