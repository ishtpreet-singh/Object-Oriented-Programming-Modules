public class M2_1Task_2 {
    private double gasolineTankCapacity;
    private double speed;
    private String model;
    private String color;
    public M2_1Task_2() {
        this.gasolineTankCapacity = 50;
        this.speed = 120;
        this.model = "Generic";
        this.color = "White";
    }
    public M2_1Task_2(double gasolineTankCapacity, double speed) {
        this();
        this.gasolineTankCapacity = gasolineTankCapacity;
        this.speed = speed;
    }

    
    public void displayCarInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Gasoline Tank Capacity: " + gasolineTankCapacity + " liters");
        System.out.println("Speed: " + speed + " km/h");
    }
    public static void main(String[] args) {
        M2_1Task_2 defaultCar = new M2_1Task_2();
        defaultCar.displayCarInfo();

        System.out.println();

        M2_1Task_2 customCar = new M2_1Task_2(60, 180);
        customCar.displayCarInfo();
    }
}