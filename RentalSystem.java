abstract class Vehicle {
    protected String vehicleNumber;
    protected String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayVehicleInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Rental Rate: " + rentalRate);
    }
}

// Interface for insurance calculation
interface Insurable {
    double calculateInsurance();
    void getInsuranceDetails();
}

// Subclass Car implementing Insurable
class Car extends Vehicle implements Insurable {
    private int seatCapacity;

    public Car(String vehicleNumber, double rentalRate, int seatCapacity) {
        super(vehicleNumber, "Car", rentalRate);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.05; // 5% insurance cost
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Car Insurance Rate: 5% of rental rate");
    }
}

// Subclass Bike implementing Insurable
class Bike extends Vehicle implements Insurable {
    private boolean hasHelmet;

    public Bike(String vehicleNumber, double rentalRate, boolean hasHelmet) {
        super(vehicleNumber, "Bike", rentalRate);
        this.hasHelmet = hasHelmet;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.03; // 3% insurance cost
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Bike Insurance Rate: 3% of rental rate");
    }
}

// Subclass Truck implementing Insurable
class Truck extends Vehicle implements Insurable {
    private double loadCapacity;

    public Truck(String vehicleNumber, double rentalRate, double loadCapacity) {
        super(vehicleNumber, "Truck", rentalRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days * 1.2; // Additional cost factor
    }

    @Override
    public double calculateInsurance() {
        return rentalRate * 0.07; // 7% insurance cost
    }

    @Override
    public void getInsuranceDetails() {
        System.out.println("Truck Insurance Rate: 7% of rental rate");
    }
}

// Main class to demonstrate polymorphism
public class RentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("Lambo", 80, 4),
                new Bike("Ducati", 10, true),
                new Truck("cybertruck", 1500, 10)
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleInfo();
            double rentalCost = vehicle.calculateRentalCost(3);
            System.out.println("Rental Cost for 4 days: " + rentalCost);

            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                System.out.println("Insurance Cost: " + insurableVehicle.calculateInsurance());
                insurableVehicle.getInsuranceDetails();
            }
            System.out.println();
        }
    }
}