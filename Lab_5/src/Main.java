import java.util.Comparator;
import java.util.List;
/**
 * Demonstrates the use of {@link Candy} subclasses and the {@link Gift} class.
 *
 * <p>This class creates a set of candies, adds them to a gift,
 * prints the gift contents, sorts candies by price, and finds candies
 * within a specified chocolate content range.</p>
 */
public class Main {
    /**
     * The main entry point of the program.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            Gift gift = new Gift();

            gift.addCandy(new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true));
            gift.addCandy(new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false));
            gift.addCandy(new ChocolateCandy("Dark Bliss", 20, 85.0, 140, 85, false));
            gift.addCandy(new CaramelCandy("Wether's", 15, 73.3, 200, 10, "liquid"));
            gift.addCandy(new CaramelCandy("Duchess", 18, 86.4, 120, 7, "solid"));
            gift.addCandy(new Lollipop("Chupa Chups", 21, 94.6, 83, 0, "apple"));
            gift.addCandy(new Lollipop("Chupa Chups", 20, 98.6, 82, 0, "cherry"));

            System.out.println(gift);

            // Sorting by price
            gift.sortBy(Comparator.comparingDouble(Candy::getPrice));
            System.out.println("\nAfter sorting by price:");
            System.out.println(gift);

            // Searching by chocolate content
            List<Candy> result = gift.findByChocolateRange(60, 90);
            System.out.println("\nCandies with 60–90% chocolate:");
            for (Candy s : result) {
                System.out.println(s);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
