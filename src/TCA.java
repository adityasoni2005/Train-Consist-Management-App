import java.util.Arrays;

public class BogieNameSorterUC17 {

    public static void main(String[] args) {
        // Example array of bogie type names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        // Sort the array alphabetically using built-in Arrays.sort()
        Arrays.sort(bogieNames);

        System.out.println("Sorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));
    }
}