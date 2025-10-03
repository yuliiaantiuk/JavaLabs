import java.util.Arrays;
import java.util.Comparator;

/**
 * Demonstrates sorting and searching of {@link Car} objects.
 */
public class Main {
    /**
     * The main method that:
     * <ul>
     *     <li>Creates an array of {@link Car} objects.</li>
     *     <li>Sorts the array by year (ascending) and price (descending).</li>
     *     <li>Searches for a specific object in the array.</li>
     * </ul>
     *
     * @param args command-line arguments (not used)
     * @throws IllegalArgumentException if the array of cars is null
     */
    public static void main(String[] args) {
        try {
            // Array initialization
            Car[] cars = new Car[] {
                    new Car("Toyota", "Corolla", 2010, 7000.0, 120_000),
                    new Car("Honda", "Civic", 2012, 9_500.0, 100_000),
                    new Car("Ford", "Focus", 2010, 6_500.0, 130_000),
                    new Car("Toyota", "Camry", 2015, 12_000.0, 80_000),
                    new Car("Honda", "Accord", 2010, 9_500.0, 110_000),
                    new Car("Toyota", "Prius", 2017, 14_500.0, 90_000)
            };

            // Comparator: primary = year (ascending), secondary = price (descending)
            Comparator<Car> comparator = Comparator.nullsLast(
                    Comparator.comparingInt(Car::getYear)
                            .thenComparing(Comparator.comparingDouble(Car::getPrice).reversed())
            );

            // Print the array before sorting
            System.out.println("Array before sorting:");
            printArray(cars);

            // Sort the array
            Arrays.sort(cars, comparator);

            // Print the array after sorting
            System.out.println("\nArray after sorting (year ascending, price descending):");
            printArray(cars);

            // Search for a given object
            Car target = new Car("Ford", "Focus", 2010, 6500.0, 130_000);

            int foundIndex = -1;
            for (int i = 0; i < cars.length; i++) {
                Car current = cars[i];
                if (current != null && current.equals(target)) {
                    foundIndex = i;
                    break;
                }
            }

            // Print search results
            if (foundIndex >= 0) {
                System.out.printf("%nTarget object is found at index %d: %s%n",
                        foundIndex, cars[foundIndex]);
            } else {
                System.out.println("\nTarget object is not found.");
            }

        } catch (NullPointerException e) {
            System.err.println("Null exception: " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid arguments exception: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Prints the contents of an array of cars with indices.
     *
     * @param cars the array of cars to print
     */
    private static void printArray(Car[] cars) {
        if (cars == null) {
            System.out.println("[null]");
            return;
        }
        for (int i = 0; i < cars.length; i++) {
            System.out.printf("%2d: %s%n", i, cars[i]);
        }
    }
}