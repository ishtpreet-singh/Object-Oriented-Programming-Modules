 class Car {
    int speed;
    int fuel;

     Car(){
    this.speed=0;
    this.fuel=100;

}

     void accelerate() {
        if (fuel > 0) {
            speed += 10;
            fuel -= 5;
            System.out.println("Car accelerates. Speed: " + speed + " km/h, Fuel: " + fuel + "%");
        } else {
            System.out.println("Out of fuel!");
        }
    }
    void decelerate() {
        if (speed > 0) {
            speed -= 5;
            System.out.println("Car decelerates. Speed: " + speed + " km/h");
        } else {
            System.out.println("Car is already stopped.");
        }
    }
}
class SportsCar extends Car{
    public void accelerate() {
        if (fuel > 0) {
            speed += 20;   
            fuel -= 10;    
            System.out.println("SportsCar accelerates quickly! Speed: " + speed + " km/h, Fuel: " + fuel + "%");
        } else {
            System.out.println("SportsCar is out of fuel!");
        }
    }

    public void decelerate() {
        if (speed > 0) {
            speed -= 10;   
            if (speed < 0);
            System.out.println("SportsCar decelerates sharply. Speed: " + speed + " km/h");
        } else {
            System.out.println("SportsCar is already stopped.");
        }
    }
}

public class Main1{
    public static void main(String[] args) {
        Car myCar = new Car();
        SportsCar mySportsCar = new SportsCar();

        System.out.println("=== Normal Car ===");
        myCar.accelerate();
        myCar.decelerate();

        System.out.println("\n=== Sports Car ===");
        mySportsCar.accelerate();
        mySportsCar.decelerate();
    }
}