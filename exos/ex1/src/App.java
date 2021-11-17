import java.util.Scanner;

public class App {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean continuer = true;
        while (continuer) {
            System.out.println("Entrer l'operande gauche");
            int g = sc.nextInt();
            System.out.println("Entrer l'operateur");
            String o = sc.next();
            System.out.println("Entrer l'operande droite");
            int d = sc.nextInt();
            Operation op = new Operation(g,d,o);
            System.out.println("resultat: "+op.calculate());
            System.out.println("Continuer ? (true/false)");
            continuer = sc.nextBoolean();
        }
    }
}
