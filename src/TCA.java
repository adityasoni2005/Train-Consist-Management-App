import java.util.*;

// Bogie class
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void display() {
        System.out.println(name + " - Capacity: " + capacity);
    }
}

// Main class
public class TrainConsistApp {
    public static void main(String[] args) {

        // Create bogie list (reuse from UC7–UC9)
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 70));

        // Step 1: Convert to stream
        // Step 2: Extract capacity using map()
        // Step 3: Sum using reduce()
        int totalCapacity = bogieList.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        // Display result
        System.out.println("Total Seating Capacity of Train: " + totalCapacity);

        // Verify original list unchanged
        System.out.println("\nOriginal Bogie List:");
        for (Bogie b : bogieList) {
            b.display();
        }
    }
}