public class M2_1Task_3 {
    private boolean isOn;
    private String coffeeType; 
    private int coffeeAmount;  

    public M2_1Task_3() {
        this.isOn = false;       
        this.coffeeType = "normal"; 
        this.coffeeAmount = 10;     
    }

    
    public M2_1Task_3(String coffeeType, int coffeeAmount) {
        this(); 
        if (coffeeType.equals("normal") || coffeeType.equals("espresso")) {
            this.coffeeType = coffeeType;
        }
        if (coffeeAmount >= 10 && coffeeAmount <= 80) {
            this.coffeeAmount = coffeeAmount;
        }
    }

    
    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
    public void setCoffeeType(String coffeeType) {
        if (isOn && (coffeeType.equals("normal") || coffeeType.equals("espresso"))) {
            this.coffeeType = coffeeType;
        }
    }

    public void setCoffeeAmount(int coffeeAmount) {
        if (isOn && coffeeAmount >= 10 && coffeeAmount <= 80) {
            this.coffeeAmount = coffeeAmount;
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }


    public static void main(String[] args) {
        M2_1Task_3 maker1 = new M2_1Task_3();
        maker1.turnOn();
        System.out.println("Coffee maker is on");
        maker1.setCoffeeType("espresso");
        maker1.setCoffeeAmount(50);
        System.out.println("Coffee type is " + maker1.getCoffeeType());
        System.out.println("Coffee amount is " + maker1.getCoffeeAmount() + " ml");
        maker1.turnOff();
        System.out.println("Coffee maker is off");

        System.out.println();

        M2_1Task_3 maker2 = new M2_1Task_3("espresso", 60);
        maker2.turnOn();
        System.out.println("Coffee maker is on");
        System.out.println("Coffee type is " + maker2.getCoffeeType());
        System.out.println("Coffee amount is " + maker2.getCoffeeAmount() + " ml");
        maker2.turnOff();
        System.out.println("Coffee maker is off");
    }
}