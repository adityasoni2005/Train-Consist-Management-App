import java.util.Scanner;

public class LinearSearchBogieUC18 {

    public static void main(String[] args) {
        // Array of bogie IDs (unsorted)
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Display all bogie IDs
        System.out.println("Bogie IDs in the train consist:");
        for (String id : bogieIDs) {
            System.out.print(id + " ");
        }
        System.out.println();

        // Accept a bogie ID to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Perform linear search
        boolean found = false;
        for (int i = 0; i < bogieIDs.length; i++) {
            if (bogieIDs[i].equals(searchKey)) {
                found = true;
                System.out.println("Bogie ID " + searchKey + " found at position " + i + ".");
                break; // Early termination once found
            }
        }

        if (!found) {
            System.out.println("Bogie ID " + searchKey + " not found in the train consist.");
        }

        scanner.close();
    }
}