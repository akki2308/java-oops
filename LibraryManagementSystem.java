abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

// Interface for reservable items
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan period
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved: " + title);
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days loan period
    }

    @Override
    public void reserveItem() {
        System.out.println("Magazine reserved: " + title);
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // 5 days loan period
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD reserved: " + title);
    }

    @Override
    public boolean checkAvailability() {
        return true;
    }
}

// Main class to demonstrate polymorphism
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
                new Book("1", "Incomplete Love", "Akshit Chauhan"),
                new Magazine("2", "Betrayl in love", "Harshit Sharma"),
                new DVD("3", "Finding Love", "Harsh Saini")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                reservableItem.reserveItem();
                System.out.println("Availability: " + reservableItem.checkAvailability());
            }
            System.out.println();
        }
    }
}