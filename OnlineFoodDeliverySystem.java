abstract class FoodItem {
    protected String itemName;
    protected double price;
    protected int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// Interface for discountable items
interface Discountable {
    void applyDiscount(double discountPercentage);
    double getDiscountDetails();
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (price * quantity) - discount;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        discount = (price * quantity) * (discountPercentage / 100);
    }

    @Override
    public double getDiscountDetails() {
        return discount;
    }
}

// NonVegItem subclass
class SweetItem extends FoodItem implements Discountable {
    private double extraCharge;
    private double discount;

    public SweetItem(String itemName, double price, int quantity, double extraCharge) {
        super(itemName, price, quantity);
        this.extraCharge = extraCharge;
    }

    @Override
    public double calculateTotalPrice() {
        return (price * quantity + extraCharge) - discount;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        discount = (price * quantity + extraCharge) * (discountPercentage / 100);
    }

    @Override
    public double getDiscountDetails() {
        return discount;
    }
}

// Main class to demonstrate polymorphism
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] order = {
                new VegItem("Rajma Chawal", 100, 3),
                new SweetItem("Ras Malai", 350, 1, 50)
        };

        for (FoodItem item : order) {
            item.getItemDetails();
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                discountableItem.applyDiscount(10);
                System.out.println("Discount Applied: " + discountableItem.getDiscountDetails());
            }
            System.out.println("Total Price: " + item.calculateTotalPrice() + "\n");
        }
    }
}