import java.util.*;

// ================================
// Custom Exception Class
// ================================
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// ================================
// Passenger Bogie Class
// ================================
class PassengerBogie {
    private String type;    // Sleeper, AC Chair, First Class
    private int capacity;

    // Constructor with capacity validation
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() { return type; }
    public int getCapacity() { return capacity; }

    public void display() {
        System.out.println(type + " Bogie with capacity " + capacity);
    }
}

// ================================
// Main Application Class
// ================================
public class TrainConsistAppUC14 {
    public static void main(String[] args) {
        List<PassengerBogie> bogies = new ArrayList<>();

        // Attempt to create bogies with valid and invalid capacities
        try {
            bogies.add(new PassengerBogie("Sleeper", 72)); // valid
            bogies.add(new PassengerBogie("AC Chair", 56)); // valid
            bogies.add(new PassengerBogie("First Class", 0)); // invalid, throws exception
        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }

        // Add another valid bogie
        try {
            bogies.add(new PassengerBogie("First Class", 40)); // valid
        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }

        // Display valid bogies in train consist
        System.out.println("\nCurrent train consist:");
        bogies.forEach(PassengerBogie::display);
    }
}