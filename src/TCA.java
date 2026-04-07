import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchBogieUC19 {

    public static void main(String[] args) {
        // Sorted array of bogie IDs (must be sorted for binary search)
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Display sorted bogie IDs
        System.out.println("Sorted Bogie IDs:");
        System.out.println(Arrays.toString(bogieIDs));

        // Accept a bogie ID to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Binary search initialization
        int low = 0;
        int high = bogieIDs.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids overflow
            int comparison = searchKey.compareTo(bogieIDs[mid]);

            if (comparison == 0) {
                found = true;
                System.out.println("Bogie ID " + searchKey + " found at position " + mid + ".");
                break;
            } else if (comparison < 0) {
                high = mid - 1; // Search in left half
            } else {
                low = mid + 1;  // Search in right half
            }
        }

        if (!found) {
            System.out.println("Bogie ID " + searchKey + " not found in the train consist.");
        }

        scanner.close();
    }
}