 public class exercise {

    public boolean niceTeeth = false;
    public String glassState = "full";
    public String phonestate = "unused";
    public boolean calling = false;
    
    public static void main(String[] args) {
        brushTeeth();
        drinkWater();
        usePhone();
        call();
    }

    public void brushTeeth(){
        this.niceTeeth = true;
    }


    public void drinkWater(){
        this.glassState = "empty";
    }

    public void usePhone(){
        this.phonestate = "used";
    }

    public void call(){
        this.calling = true;
    }

}