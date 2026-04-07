import java.util.*;

// Bogie class
class Bogie {
    String name;
    int capacity;

    // Constructor
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    // Display method
    public void display() {
        System.out.println(name + " - Capacity: " + capacity);
    }
}

// Main class
public class TCA {
    public static void main(String[] args) {

        // Create list to store bogies
        List<Bogie> bogieList = new ArrayList<>();

        // Add passenger bogies
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        // Sort bogies using Comparator (by capacity)
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Display sorted bogies
        System.out.println("Bogies Sorted by Capacity:");
        for (Bogie b : bogieList) {
            b.display();
        }
    }
}