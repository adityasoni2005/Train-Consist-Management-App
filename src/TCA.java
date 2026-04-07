import java.util.Arrays;
import java.util.Scanner;

public class SearchBogieUC20 {

    public static void main(String[] args) {
        // Example bogie array (can be empty)
        String[] bogieIDs = {};  // Empty array to demonstrate defensive check

        // Attempt to search a bogie
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bogie ID to search: ");
        String searchKey = scanner.nextLine();

        try {
            // Defensive check: throw exception if array is empty
            if (bogieIDs.length == 0) {
                throw new IllegalStateException("Cannot search: No bogies are available in the train!");
            }

            // Linear search logic (from UC18)
            boolean found = false;
            for (int i = 0; i < bogieIDs.length; i++) {
                if (bogieIDs[i].equals(searchKey)) {
                    found = true;
                    System.out.println("Bogie ID " + searchKey + " found at position " + i + ".");
                    break;
                }
            }

            if (!found) {
                System.out.println("Bogie ID " + searchKey + " not found in the train consist.");
            }

        } catch (IllegalStateException ex) {
            // Handle the empty train scenario gracefully
            System.err.println("Error: " + ex.getMessage());
        } finally {
            System.out.println("Search operation completed.");
        }

        scanner.close();
    }
}