abstract class Product {
    protected int productId;
    protected String name;
    protected double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayProductDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

// Interface for tax calculation
interface Taxable {
    double calculateTax();
    void getTaxDetails();
}

// Subclass Electronics implementing Taxable
class Electronics extends Product implements Taxable {
    private String brand;
    private double discount;

    public Electronics(int productId, String name, double price, String brand, double discount) {
        super(productId, name, price);
        this.brand = brand;
        this.discount = discount;
    }

    @Override
    public double calculateDiscount() {
        return price * discount;
    }

    @Override
    public double calculateTax() {
        return price * 0.15; // 15% tax
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax for Electronics: 15%");
    }
}

// Subclass Clothing implementing Taxable
class Clothing extends Product implements Taxable {
    private String size;
    private double discount;

    public Clothing(int productId, String name, double price, String size, double discount) {
        super(productId, name, price);
        this.size = size;
        this.discount = discount;
    }

    @Override
    public double calculateDiscount() {
        return price * discount;
    }

    @Override
    public double calculateTax() {
        return price * 0.08; // 8% tax
    }

    @Override
    public void getTaxDetails() {
        System.out.println("Tax for Clothing: 8%");
    }
}

// Subclass Groceries (not taxable)
class Groceries extends Product {
    private String expiryDate;
    private double discount;

    public Groceries(int productId, String name, double price, String expiryDate, double discount) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
        this.discount = discount;
    }

    @Override
    public double calculateDiscount() {
        return price * discount;
    }
}

// Main class to demonstrate polymorphism
public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
                new Electronics(101, "pc", 10000, "lg", 0.30),
                new Clothing(202, "jeans", 5000, "L", 5),
                new Groceries(303, "cheese", 4, "2025-04-06", 0.5)
        };

        for (Product product : products) {
            product.displayProductDetails();
            System.out.println("Discount Price: " + product.calculateDiscount());
            double finalPrice = product.price - product.calculateDiscount();
            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                finalPrice += taxableProduct.calculateTax();
                taxableProduct.getTaxDetails();
            }
            System.out.println("Final Price: " + finalPrice + "\n");
        }
    }
}