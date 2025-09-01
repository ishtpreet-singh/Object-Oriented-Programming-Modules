interface Vehicle {
    void start();
    void stop();
    String getInfo();
}

abstract class AbstractVehicle implements Vehicle {
    protected String brand;
    protected String model;
    protected int year;

    public AbstractVehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println(brand + " " + model + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(brand + " " + model + " is stopping...");
    }

    @Override
    public abstract String getInfo();

    public void displayBasicInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}

class Car extends AbstractVehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int year, int numberOfDoors) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String getInfo() {
        return "Car -> " + brand + " " + model + " (" + year + "), Doors: " + numberOfDoors;
    }
}

class Motorcycle extends AbstractVehicle {
    private int engineCapacity;

    public Motorcycle(String brand, String model, int year, int engineCapacity) {
        super(brand, model, year);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String getInfo() {
        return "Motorcycle -> " + brand + " " + model + " (" + year + "), Engine: " + engineCapacity + "cc";
    }
}

class Bus extends AbstractVehicle {
    private int seatingCapacity;

    public Bus(String brand, String model, int year, int seatingCapacity) {
        super(brand, model, year);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String getInfo() {
        return "Bus -> " + brand + " " + model + " (" + year + "), Seats: " + seatingCapacity;
    }
}

public class VehicleDem1 {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Corolla", 2022, 4);
        Vehicle motorcycle = new Motorcycle("Yamaha", "R15", 2021, 155);
        Vehicle bus = new Bus("Volvo", "B9R", 2020, 50);

        Vehicle[] vehicles = {car, motorcycle, bus};

        for (Vehicle v : vehicles) {
            v.start();
            System.out.println(v.getInfo());
            v.stop();
            System.out.println();
        }
    }
}