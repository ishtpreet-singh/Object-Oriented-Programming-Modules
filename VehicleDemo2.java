interface Vehicle {
    void start();
    void stop();
    String getInfo();
}

interface ElectricVehicle {
    void charge();
}

abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
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

    @Override
    public void charge() {
        System.out.println(brand + " " + model + ": Not possible to charge.");
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

class ElectricCar extends AbstractVehicle {
    private int batteryCapacity;

    public ElectricCar(String brand, String model, int year, int batteryCapacity) {
        super(brand, model, year);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String getInfo() {
        return "Electric Car -> " + brand + " " + model + " (" + year + "), Battery: " + batteryCapacity + " kWh";
    }

    @Override
    public void charge() {
        System.out.println(brand + " " + model + " is charging...");
    }
}

class ElectricMotorcycle extends AbstractVehicle {
    private int batteryCapacity;

    public ElectricMotorcycle(String brand, String model, int year, int batteryCapacity) {
        super(brand, model, year);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String getInfo() {
        return "Electric Motorcycle -> " + brand + " " + model + " (" + year + "), Battery: " + batteryCapacity + " kWh";
    }

    @Override
    public void charge() {
        System.out.println(brand + " " + model + " is charging...");
    }
}

public class VehicleDemo2 {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Toyota", "Corolla", 2022, 4),
            new Motorcycle("Yamaha", "R15", 2021, 155),
            new Bus("Volvo", "B9R", 2020, 50),
            new ElectricCar("Tesla", "Model 3", 2023, 75),
            new ElectricMotorcycle("Zero", "SR/F", 2022, 14)
        };

        for (Vehicle v : vehicles) {
            v.start();
            System.out.println(v.getInfo());
            v.stop();
            if (v instanceof ElectricVehicle) {
                ((ElectricVehicle) v).charge();
            }
            System.out.println();
        }
    }
}