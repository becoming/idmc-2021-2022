import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Calculator {

    public HashMap<String, String> dict = new HashMap<String, String>();
    public ArrayList<String> randomReponse = new ArrayList<String>();

    public Calculator() {
        dict.put("England", "London");
        dict.put("Germany", "Berlin");
        dict.put("Norway", "Oslo");
        dict.put("USA", "Washington DC");
        dict.put("Moldova", "Chisineau");
        randomReponse.add("Première réponse");
        randomReponse.add("Deuxième réponse");
        randomReponse.add("Troisième réponse");
    }

    public static int menu() {
        int selection;
        Scanner input = new Scanner(System.in);
        /***************************************************/
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Show dict");
        System.out.println("2 - Talk with a bot");
        System.out.println("3 - Do nothing");
        System.out.println("4 - Do nothing again");
        System.out.println("5 - Exit");
        selection = input.nextInt();
        return selection;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        while (true) {
            int choice = menu();
            switch (choice) {
            case 1:
                System.out.println(calc.dict.toString());
                break;
            case 2:
                int i = new Random().nextInt(calc.randomReponse.size());
                System.out.println();
                System.out.println(calc.randomReponse.get(i));
                break;
            case 3:
                System.out.println("no option 3");
                break;
            case 4:
                System.out.println("no option 4");
                break;
            case 5:
                System.out.println("close");
                System.exit(0);
                break;
            default:
                System.out.println("close");
                System.exit(0);
            }
        }
    }
}