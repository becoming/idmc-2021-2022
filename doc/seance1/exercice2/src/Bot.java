import java.util.Map;
import java.util.Scanner;

public class Bot {

    public static void main(final String[] args) {
        final String[] answers = {
                "- Bonjour",
                "- J'aime les crêpes !",
                "- L'alcool c'est mal !",
                "- " + System.currentTimeMillis() + " millisecondes se sont écoulées depuis janvier 1970",
                "- Vous êtes le plus beau !",
                "- La miage c'est TOP !",
                "- Il fait moche aujourd'hui !",
                "- Je ne peux pas répondre à ça !"
        };

        final Scanner scanner = new Scanner(System.in);
        System.out.println("Je suis le bot !");
        while(true) {
            System.out.println();
            System.out.print("Quel est votre question ? ");
            String question = scanner.nextLine();
            System.out.println(answers[(int)(Math.random() * answers.length - 1)]);
        }
    }
}