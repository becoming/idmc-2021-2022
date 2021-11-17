public class Operation {
    private int operandeGauche;
    private int operandeDroite;
    private String operateur;

    public Operation(int operandeGauche, int operandeDroite, String operateur) {
        this.operandeGauche = operandeGauche;
        this.operandeDroite = operandeDroite;
        this.operateur = operateur;
    }

    public  String calculate() {
        String res = null ;
        switch(operateur){
            case "+":
               res= Integer.toString(this.operandeGauche + this.operandeDroite);
               break;
            case "-":
                res= Integer.toString(this.operandeGauche - this.operandeDroite);
                break;
            case "*":
                res= Integer.toString(this.operandeGauche * this.operandeDroite);
                break;
            default: res = "Operation inconnue";
        }
        return res;
    }
}
