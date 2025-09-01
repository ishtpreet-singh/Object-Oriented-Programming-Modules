interface Vehicle {
    void start();
    void stop();
    String getInfo();
    double calculateFuelEfficiency();
}

interface ElectricVehicle {
    void charge();
}

abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double fuelEfficiency;

    public AbstractVehicle(String brand, String model, int year, double fuelEfficiency) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelEfficiency = fuelEfficiency;
    }

    public void start() {
        System.out.println(brand + " " + model + " is starting...");
    }

    public void stop() {
        System.out.println(brand + " " + model + " is stopping...");
    }

    public abstract String getInfo();

    public void charge() {
        System.out.println(brand + " " + model + ": Not possible to charge.");
    }

    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }
}

class Car extends AbstractVehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int year, int numberOfDoors, double fuelEfficiency) {
        super(brand, model, year, fuelEfficiency);
        this.numberOfDoors = numberOfDoors;
    }

    public String getInfo() {
        return "Car -> " + brand + " " + model + " (" + year + "), Doors: " + numberOfDoors;
    }
}

class Motorcycle extends AbstractVehicle {
    private int engineCapacity;

    public Motorcycle(String brand, String model, int year, int engineCapacity, double fuelEfficiency) {
        super(brand, model, year, fuelEfficiency);
        this.engineCapacity = engineCapacity;
    }

    public String getInfo() {
        return "Motorcycle -> " + brand + " " + model + " (" + year + "), Engine: " + engineCapacity + "cc";
    }
}

class Bus extends AbstractVehicle {
    private int seatingCapacity;

    public Bus(String brand, String model, int year, int seatingCapacity, double fuelEfficiency) {
        super(brand, model, year, fuelEfficiency);
        this.seatingCapacity = seatingCapacity;
    }

    public String getInfo() {
        return "Bus -> " + brand + " " + model + " (" + year + "), Seats: " + seatingCapacity;
    }
}

class ElectricCar extends AbstractVehicle {
    private int batteryCapacity;

    public ElectricCar(String brand, String model, int year, int batteryCapacity, double efficiencyKWhPerKm) {
        super(brand, model, year, efficiencyKWhPerKm);
        this.batteryCapacity = batteryCapacity;
    }

    public String getInfo() {
        return "Electric Car -> " + brand + " " + model + " (" + year + "), Battery: " + batteryCapacity + " kWh";
    }

    public void charge() {
        System.out.println(brand + " " + model + " is charging...");
    }
}

class ElectricMotorcycle extends AbstractVehicle {
    private int batteryCapacity;

    public ElectricMotorcycle(String brand, String model, int year, int batteryCapacity, double efficiencyKWhPerKm) {
        super(brand, model, year, efficiencyKWhPerKm);
        this.batteryCapacity = batteryCapacity;
    }

    public String getInfo() {
        return "Electric Motorcycle -> " + brand + " " + model + " (" + year + "), Battery: " + batteryCapacity + " kWh";
    }

    public void charge() {
        System.out.println(brand + " " + model + " is charging...");
    }
}

public class VehicleDemo3
 {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Toyota", "Corolla", 2022, 4, 30.5),
            new Motorcycle("Yamaha", "R15", 2021, 155, 45.2),
            new Bus("Volvo", "B9R", 2020, 50, 5.5),
            new ElectricCar("Tesla", "Model 3", 2023, 75, 0.15),
            new ElectricMotorcycle("Zero", "SR/F", 2022, 14, 0.08)
        };

        for (Vehicle v : vehicles) {
            v.start();
            System.out.println(v.getInfo());
            System.out.println("Fuel Efficiency: " + v.calculateFuelEfficiency());
            v.stop();
            if (v instanceof ElectricVehicle) {
                ((ElectricVehicle) v).charge();
            }
            System.out.println();
        }
    }
}