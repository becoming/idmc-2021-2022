import java.util.Scanner;

public class Console {

    public static void main(String[] args) {

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("------------------------------------");
            System.out.println("Pour afficher la température tapez 1");
            System.out.println("Pour être accueilli tapez 2");
            System.out.println("Pour prendre la voiture tapez 3");
            System.out.println("Pour boire un verre d'eau tapez 4");
            System.out.println("Pour quitter tapez 5");
            System.out.println("------------------------------------");
            System.out.println();

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Il fait nuageux et 7°C.");
                    break;
                case 2:
                    System.out.println("Bonjour, je suis ravi de vous voir ici.");
                    break;
                case 3:
                    System.out.println("Vrouuuum...");
                    break;
                case 4:
                    System.out.println("Glou glou..");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mauvais choix d'option !");
            }
        }
    }
}
