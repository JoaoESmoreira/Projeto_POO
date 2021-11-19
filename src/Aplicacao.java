import java.nio.file.attribute.AclEntry;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Aplicacao {
    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args){
        adicionaClientes(new Data(2002,3, 10), new Data(1992, 5, 16), new Data(1989, 10, 3));
        login();
    }

    public static void adicionaClientes(Data d, Data d1, Data d2){
        clientes.add(new Cliente("Francisco", "Coimbra", "fmacedo@student.uc.pt", 967546948, d));
        clientes.add(new Cliente("Manuel", "Lisboa", "manuel.mail@gmail.com", 915473877, d1));
        clientes.add(new Cliente("Joana", "Porto", "joana.mail@hotmail.com", 924106841, d2));
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
