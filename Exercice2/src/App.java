public class App {
    public static void main(String[] args) throws Exception {
        Integer rep = BoiteAoutils.menu();
        while (rep != 0) {
            rep = BoiteAoutils.menu();
        }
    }
}
