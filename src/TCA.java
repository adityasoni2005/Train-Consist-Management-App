public class PassengerBogieSorterUC16 {

    // Bubble Sort method for ascending order
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {          // Number of passes
            for (int j = 0; j < n - i - 1; j++) {  // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {
                    // Swap values
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    // Display array elements
    public static void displayArray(int[] capacities) {
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] bogieCapacities = {72, 56, 24, 70, 60}; // Example passenger bogie capacities

        System.out.println("Original Capacities:");
        displayArray(bogieCapacities);

        // Perform Bubble Sort
        bubbleSort(bogieCapacities);

        System.out.println("Sorted Capacities (Ascending):");
        displayArray(bogieCapacities);
    }
}