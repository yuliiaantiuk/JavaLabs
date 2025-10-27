import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Gift gift = new Gift();

            gift.addCandy(new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true));
            gift.addCandy(new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false));
            gift.addCandy(new ChocolateCandy("Dark Bliss", 20, 85.0, 140, 85, false));
            gift.addCandy(new CaramelCandy("Wether's", 15, 73.3, 200, 10, "liquid"));
            gift.addCandy(new CaramelCandy("Duchess", 18, 86.4, 120, 7, "solid"));
            gift.addCandy(new Lollipop("Chupa Chups", 21, 94.6, 83, 0, "apple"));

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
