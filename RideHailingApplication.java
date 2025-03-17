abstract class RideVehicle {
    protected String vehicleId;
    protected String driverName;
    protected double ratePerKm;

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm);
    }
}

// Interface for GPS functionality
interface GPS {
    void getCurrentLocation();
    void updateLocation(String location);
}

// Car subclass
class CarRide extends RideVehicle implements GPS {
    public CarRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Car location: Retrieved");
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("Car location updated to: " + location);
    }
}

// Bike subclass
class BikeRide extends RideVehicle implements GPS {
    public BikeRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Bike location: Retrieved");
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("Bike location updated to: " + location);
    }
}

// Auto subclass
class Auto extends RideVehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Auto location: Retrieved");
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("Auto location updated to: " + location);
    }
}

// Main class to demonstrate polymorphism
public class RideHailingApplication {
    public static void main(String[] args) {
        RideVehicle[] vehicles = {
                new CarRide("01", "John wick", 5),
                new BikeRide("02", "Akshay", 2),
                new Auto("03", "Rithik", 4)
        };

        for (RideVehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            if(vehicle instanceof GPS) {
                GPS location = (GPS) vehicle;
                location.getCurrentLocation();
                if (vehicle instanceof CarRide) {
                    location.updateLocation("Nearby Petrol punp");
                }
            }
            System.out.println("Fare for 10 km: " + vehicle.calculateFare(10) + "\n");
        }
    }
}