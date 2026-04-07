import java.util.*;

// Goods Bogie class
class GoodsBogie {
    String type;   // Cylindrical, Rectangular, Open, etc.
    String cargo;  // Petroleum, Coal, Grain, etc.

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public void display() {
        System.out.println(type + " Bogie carrying " + cargo);
    }
}

// Main class
public class TrainConsistApp {
    public static void main(String[] args) {

        // Create goods bogies
        List<GoodsBogie> goodsList = new ArrayList<>();
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Rectangular", "Coal"));
        goodsList.add(new GoodsBogie("Open", "Grain"));
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Safety validation using stream
        boolean isSafe = goodsList.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );

        // Display result
        if (isSafe) {
            System.out.println("Train is SAFE for operation ✅");
        } else {
            System.out.println("Train is NOT SAFE ❌");
        }

        // Display bogies
        System.out.println("\nGoods Bogies:");
        goodsList.forEach(GoodsBogie::display);
    }
}