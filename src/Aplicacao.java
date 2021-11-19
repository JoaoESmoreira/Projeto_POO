import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Aplicacao {
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args){
        adicionaClientes();
        login();
    }

    public static void adicionaClientes(){
        clientes.add(new Cliente("Francisco", "Coimbra", "fmacedo@student.uc.pt", 969715348, new Data(2002,3, 10)));
        clientes.add(new Cliente("Manuel", "Lisboa", "manuel.mail@gmail.com", 915473877, new Data(1992, 5, 16)));
        clientes.add(new Cliente("Joana", "Porto", "joana.mail@hotmail.com", 924106841, new Data(198
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
}
