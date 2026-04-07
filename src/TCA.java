import java.util.*;

// ================================
// Custom Runtime Exception Class
// ================================
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// ================================
// Goods Bogie Class
// ================================
class GoodsBogie {
    private String shape;   // Rectangular, Cylindrical
    private String cargo;   // Coal, Grain, Petroleum, etc.

    public GoodsBogie(String shape) {
        this.shape = shape;
        this.cargo = null;
    }

    public String getShape() { return shape; }
    public String getCargo() { return cargo; }

    // Assign cargo safely with runtime validation
    public void assignCargo(String cargo) {
        try {
            // Business rule: Rectangular bogie cannot carry Petroleum
            if ("Rectangular".equalsIgnoreCase(shape) && "Petroleum".equalsIgnoreCase(cargo)) {
                throw new CargoSafetyException(
                        "Unsafe cargo assignment: Rectangular bogie cannot carry Petroleum"
                );
            }
            // Assign cargo if valid
            this.cargo = cargo;
            System.out.println("Cargo '" + cargo + "' assigned to " + shape + " bogie successfully.");
        } catch (CargoSafetyException e) {
            // Handle unsafe assignment gracefully
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Always executed for logging / cleanup
            System.out.println("Cargo assignment validation completed for " + shape + " bogie.\n");
        }
    }
}

// ================================
// Main Application Class
// ================================
public class TrainConsistAppUC15 {
    public static void main(String[] args) {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Rectangular"));
        bogies.add(new GoodsBogie("Cylindrical"));

        // Attempt safe and unsafe cargo assignments
        bogies.get(0).assignCargo("Coal");          // Safe
        bogies.get(0).assignCargo("Petroleum");     // Unsafe
        bogies.get(1).assignCargo("Petroleum");     // Safe
        bogies.get(1).assignCargo("Grain");         // Safe

        // Display final cargo assignments
        System.out.println("Final Cargo Assignments:");
        for (GoodsBogie b : bogies) {
            System.out.println(b.getShape() + " bogie -> Cargo: " + b.getCargo());
        }
    }
}