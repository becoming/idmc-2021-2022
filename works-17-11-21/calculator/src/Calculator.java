import java.util.Scanner;

public class Calculator {

    public void askCalculation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quelle opération voulez vous faire ?");
        System.out.println("1 - addition");
        System.out.println("2 - soustraction");
        System.out.println("3 - multiplication");
        System.out.println("4 - division");

        int operator = sc.nextInt();

        System.out.println("Entrez le 1er terme : ");
        Double a = sc.nextDouble();

        System.out.println("Entrez le 2ème terme : ");
        Double b = sc.nextDouble();

        this.calculate(a, b, operator);
    }

    public void calculate(Double a, Double b, int operator){
        Double res = 0.0;
        switch(operator){
            case 1:
                res = this.add(a, b);
                break;
            case 2:
                res = this.subtract(a, b);
                break;
            case 3:
                res = this.multiply(a, b);
                break;
            case 4:
                res = this.divide(a, b);
                break;
            default:
                break;
        }
        System.out.println("Résultat : " + res);
    }

    public Double add(Double a, Double b){
        return a+b;
    }

    public Double subtract(Double a, Double b){
        return a-b;
    }

    public Double multiply(Double a, Double b){
        return a*b;
    }

    public Double divide(Double a, Double b){
        return a/b;
    }


}
