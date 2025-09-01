
import java.util.Scanner;

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
class Bus {
    //
    
     void passengerEnter(){
        System.out.print("Enter Num of Passenger Enter: ");
    }
     void passengerExit(){
        System.out.print("Enter Num of Passenger Exit: ");}
    }

public class Main1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car myCar = new Car();
        SportsCar mySportsCar = new SportsCar();
        Bus mybus=new Bus();

        System.out.println("=== Normal Car ===");
        myCar.accelerate();
        myCar.decelerate();

        System.out.println("\n=== Sports Car ===");
        mySportsCar.accelerate();
        mySportsCar.decelerate();

        System.out.println("=== Bus ===");
        
        
        mybus.passengerEnter();
        int x= scanner.nextInt();
        System.out.println("Number of passengers enter in the bus are "+x);
        mybus.passengerExit();
        int y= scanner.nextInt();
        System.out.println("Number of passengers exit in the bus are "+y);
        System.out.println("Remaining passengers: "+(x-y));
    }
}
 