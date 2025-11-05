import java.util.*;
/**
 * Demonstrates the functionality of the {@link LinkedSet} class using {@code Candy} objects.
 * <p>
 * The program creates and manipulates a collection of candy objects wrapped in a {@code LinkedSet},
 * demonstrating the performance of operations such as:
 * </p>
 * <ul>
 *   <li>Creating sets with constructors</li>
 *   <li>Adding and removing elements</li>
 *   <li>Iterating through a set</li>
 *   <li>Checking containment and set relationships</li>
 *   <li>Converting a set to arrays</li>
 *   <li>Using {@code retainAll}, {@code removeAll}, and {@code clear}</li>
 * </ul>
 * <p>
 * This class serves as a demonstration driver for testing the custom {@code LinkedSet} implementation.
 * </p>
 *
 */
public class Main {
    /**
     * The main entry point of the application.
     * <p>
     * It initializes several {@code Candy} objects of different types
     * ({@code ChocolateCandy}, {@code CaramelCandy}, {@code Lollipop}) and performs a
     * series of {@code LinkedSet} operations to demonstrate functionality.
     * </p>
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Create a list of various Candy objects
        List<Candy> gift = new ArrayList<>();
        // Insert different candy types in the list
        gift.add(new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true));
        gift.add(new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false));
        gift.add(new ChocolateCandy("Dark Bliss", 20, 85.0, 140, 85, false));
        gift.add(new CaramelCandy("Wether's", 15, 73.3, 200, 10, "liquid"));
        gift.add(new CaramelCandy("Duchess", 18, 86.4, 120, 7, "solid"));
        gift.add(new Lollipop("Chupa Chups", 21, 94.6, 83, 0, "apple"));
        gift.add(new Lollipop("Chupa Chups", 20, 98.6, 82, 0, "cherry"));
        // Initialize LinkedSet with a collection of candies
        LinkedSet<Candy> candySet = new LinkedSet<>(gift);

        System.out.println("Original candySet: " +  candySet.toString());
        System.out.println("Size of candySet: " + candySet.size());

        // Add a new chocolate candy
        ChocolateCandy newCandy = new ChocolateCandy("Millenium", 32, 98.2, 120, 80, true);
        candySet.add(newCandy);

        System.out.println("candySet after adding newCandy: " +  candySet.toString());
        System.out.println("Size of candySet: " + candySet.size());

        // Attempt to add the same candy again (duplicated element)
        System.out.println("Duplicating newCandy: " + candySet.add(newCandy));
        System.out.println("Size of candySet: " + candySet.size());

        candySet.remove(newCandy);

        System.out.println("candySet after removing newCandy: " +  candySet.toString());
        System.out.println("Size of candySet: " + candySet.size());

        Candy searchedCandy = gift.get(3);

        System.out.println("searchedCandy: " + searchedCandy.toString());
        System.out.println("candySet contains searchCandy: " +  candySet.contains(searchedCandy));

        System.out.println("newCandy that was deleted and now does not exist in set: " + newCandy.toString());
        System.out.println("candySet contains newCandy: " +  candySet.contains(newCandy));

        System.out.println("Iterating through candySet: ");
        Iterator<Candy> iterator = candySet.iterator();
        while (iterator.hasNext()) {
            Candy candy = iterator.next();
            System.out.println(" - " + candy);
        }
        System.out.println();

        Object[] candyArray = candySet.toArray();
        System.out.println("Array Object[]: " + Arrays.toString(candyArray));
        System.out.println();

        Candy[] candyTypeArray = candySet.toArray(new Candy[0]);
        System.out.println("Array Candy[]: " + Arrays.toString(candyTypeArray));
        System.out.println();

        List<Candy> subList = gift.subList(0, 3);
        System.out.println("subList: " + subList);
        System.out.println("candySet contains all the elements of subList: " + candySet.containsAll(subList));
        System.out.println();

        List<Candy> newCandies = new ArrayList<>();
        newCandies.add(new CaramelCandy("Duchess", 13, 86.4, 120, 0, "liquid"));
        newCandies.add(new Lollipop("Cherry Boom", 22, 90.0, 70, 0, "cherry"));

        candySet.addAll(newCandies);
        System.out.println("candySet after adding the whole collection through addAll: " + candySet.toString());
        System.out.println("Size of candySet: " + candySet.size());
        System.out.println();

        candySet.retainAll(newCandies);
        System.out.println("Keeping only newCandies with retainAll: " + candySet);
        System.out.println("Size of candySet: " + candySet.size());
        System.out.println();

        candySet.addAll(gift);
        System.out.println("After adding the old candies: " + candySet);
        System.out.println("Size of candySet: " + candySet.size());
        candySet.removeAll(gift.subList(0, 3));
        System.out.println("After removing 3 candies with removeAll: " + candySet);
        System.out.println("Size of candySet: " + candySet.size());
        System.out.println();

        candySet.clear();
        System.out.println("candySet after clear(): " + candySet);
        System.out.println("Size of candySet: " + candySet.size());
        System.out.println("Is candySet empty: " + candySet.isEmpty());
        System.out.println();

        LinkedSet<Candy> emptyCandySet = new LinkedSet<>();
        System.out.println("Size of emptyCandySet: " + emptyCandySet.size());
        System.out.println("Is emptyCandySet empty: " + emptyCandySet.isEmpty());
        System.out.println();

        LinkedSet<Candy> singleCandySet = new LinkedSet<>(new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false));
        System.out.println("Size of singleCandySet: " + singleCandySet.size());
        System.out.println("Is singleCandySet empty: " + singleCandySet.isEmpty());
    }
}