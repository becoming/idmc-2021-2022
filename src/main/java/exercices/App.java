package exercices;

import java.util.Scanner;

public class App{

    public static String[] menu = new String[] {
        "Commander", 
        "Réserver", 
        "Emprunter",
        "Tester", 
        "Exit"  
      };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenue");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + " : " + menu[i]);
        }
        System.out.println("Sélectionner un choix");
        boolean terminer = false;
        while(!terminer){
            String textString = sc.next();
            try {
                int choix = Integer.parseInt(textString);
                if(choix >= 0 && choix < menu.length-1){
                    System.out.println("Vous avez choisi " + menu[choix]);
                }
                else if(choix == menu.length-1){
                    terminer = true;
                    System.out.println("Au revoir");
                }
                else{
                    System.out.println("C'est pas dans la liste bien essayé ^^");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Ce n'est pas un nombre");
            }
        }
        sc.close();
        
        
    }
}