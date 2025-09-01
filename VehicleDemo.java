// Vehicle.java
interface Vehicle {
    void start();
    void stop();
    String getInfo();
}

// Car.java
class Car implements Vehicle {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String getInfo() {
        return "Car: " + brand + " " + model;
    }
}

// Motorcycle.java
class Motorcycle implements Vehicle {
    private String brand;
    private int engineCapacity;

    public Motorcycle(String brand, int engineCapacity) {
        this.brand = brand;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return "Motorcycle: " + brand + ", Engine: " + engineCapacity + "cc";
    }
}

// Bus.java
class Bus implements Vehicle {
    private String company;
    private int seatingCapacity;

    public Bus(String company, int seatingCapacity) {
        this.company = company;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        return "Bus: " + company + ", Seats: " + seatingCapacity;
    }
}

// VehicleDemo.java
public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Corolla");
        Vehicle motorcycle = new Motorcycle("Yamaha", 150);
        Vehicle bus = new Bus("Volvo", 50);

        Vehicle[] vehicles = {car, motorcycle, bus};

        for (Vehicle v : vehicles) {
            v.start();
            System.out.println(v.getInfo());
            v.stop();
            System.out.println();
        }
    }
}