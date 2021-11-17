package exercices;

import java.util.Scanner;

public class Exercice2 {

    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenue, choisissez une option :");
        String[] options = {"A", "B", "C", "D", "E"};

        for ( int i = 0; i < options.length; i ++) {
            System.out.println( i + " - " + options[i]);
        }
        Scanner in = new Scanner(System.in);
        boolean termine = false;
        while(!termine){
            String resultat = in.next();
            try {
                int index = Integer.parseInt(resultat);
                System.out.println("Merci à bientôt : " + options[index]);
            }catch (Exception e){
                System.err.println("Votre réponse ne fait pas partie des options, veuillez recommencer");
            }
        }

        in.close();
    }
}



