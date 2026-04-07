import java.util.*;
import java.util.stream.Collectors;

// Passenger Bogie class
class PassengerBogie {
    String name;  // Sleeper, AC Chair, First Class
    int capacity;

    public PassengerBogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    public void display() {
        System.out.println(name + " Bogie with capacity " + capacity);
    }
}

// Main class
public class TrainConsistPerformanceApp {
    public static void main(String[] args) {

        // Generate sample bogies (can scale up for performance test)
        List<PassengerBogie> bogies = new ArrayList<>();
        bogies.add(new PassengerBogie("Sleeper", 72));
        bogies.add(new PassengerBogie("AC Chair", 56));
        bogies.add(new PassengerBogie("First Class", 40));
        bogies.add(new PassengerBogie("Sleeper", 72));
        bogies.add(new PassengerBogie("AC Chair", 56));

        // ================================
        // Loop-based Filtering
        // ================================
        long loopStart = System.nanoTime();

        List<PassengerBogie> loopFiltered = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        System.out.println("Loop-based filtered bogies:");
        loopFiltered.forEach(PassengerBogie::display);
        System.out.println("Loop execution time (ns): " + loopDuration);

        // ================================
        // Stream-based Filtering
        // ================================
        long streamStart = System.nanoTime();

        List<PassengerBogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        System.out.println("\nStream-based filtered bogies:");
        streamFiltered.forEach(PassengerBogie::display);
        System.out.println("Stream execution time (ns): " + streamDuration);

        // ================================
        // Compare results
        // ================================
        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("\nBoth methods returned the same number of bogies ✅");
        } else {
            System.out.println("\nMismatch in filtered results ❌");
        }
    }
}