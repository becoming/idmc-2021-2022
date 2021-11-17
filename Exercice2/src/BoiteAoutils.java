import java.util.Scanner;

public class BoiteAoutils {
    public static int menu() {
        Scanner s = new Scanner(System.in);
        String n = System.getProperty("line.separator");
        System.out.println("--------------------------------------" + n + "      Menu" + n
                + "--------------------------------------" + n + "1. Option 1" + n + "2. Option 2" + n + "3. Option 3"
                + n + "4. Option 4" + n + "5. Option 5" + n + n + "0. Quitter" + n + n + n + "Que voulez vous faire?");
        int rep = s.nextInt();
        boolean ok = verifiMenu(rep);
        while (!ok) {
            System.out.println("Cette réponse n'est pas possible! Recommencez!");
            rep = s.nextInt();
            ok = verifiMenu(rep);
        }
        return rep;
    }

    private static boolean verifiMenu(int r) {
        return (r >= 0 && r <= 5);
    }
}
