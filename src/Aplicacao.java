import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Aplicacao {
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void adicionaClientes(){
        clientes.add(new Cliente("Francisco", "Coimbra", "fmacedo@student.uc.pt", 969715348, new Data(2002,3, 10)));
        clientes.add(new Cliente("Manuel", "Lisboa", "manuel.mail@gmail.com", 915473877, new Data(1992, 5, 16)));
        clientes.add(new Cliente("Joana", "Porto", "joana.mail@hotmail.com", 924106841, new Data(1989, 10, 3)));
    }

    public static void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza o endereco de email: ");
        String email = scanner.nextLine();

        for(Cliente c: clientes){
            if(Objects.equals(c.getEmail(), email)){
                System.out.println("Bem vind@, " + c.getNome() + "!");
                c.setLoggedIn(true);
                break;
            }
        }
    }

    // TODO opiniao do francisco
    // o que eu fiz, da a possibilidade de o utilizador errar o email
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
        Scanner sn          = new Scanner(System.in);
        boolean verificacao = false;

        do {
            System.out.print("Introduza o endereco de email: ");
            String email = sn.nextLine();

            verificacao  = verificaLogin(email);

        } while (!verificacao);

    }

    public static void main(String[] args){
        adicionaClientes();
        login1();
    }
}
