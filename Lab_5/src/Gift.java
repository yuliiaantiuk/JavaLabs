import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Represents a gift that consists of different types of candies.
 *
 * <p>The {@code Gift} class allows adding candies, sorting them,
 * calculating total characteristics (price, weight, calories),
 * and searching candies by their chocolate content percentage.</p>
 */
public class Gift {
    /** The list of candies included in this gift. */
    private final List<Candy> candies;
    /** Constructs an empty gift. */
    public Gift() {
        this.candies = new ArrayList<>();
    }
    /**
     * Adds a candy to the gift.
     *
     * @param candy the candy to add
     * @throws IllegalArgumentException if the candy is {@code null}
     */
    public void addCandy(Candy candy) {
        if (candy == null) {
            throw new IllegalArgumentException("Candy cannot be null.");
        }
        candies.add(candy);
    }
    /**
     * Calculates the total price of all candies in the gift.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        double total = 0.0;
        for (Candy candy : candies) {
            total += candy.getPrice();
        }
        return total;
    }
    /**
     * Calculates the total weight of all candies in the gift.
     *
     * @return the total weight in grams
     */
    public double getTotalWeight() {
        double total = 0.0;
        for (Candy candy : candies) {
            total += candy.getWeight();
        }
        return total;
    }
    /**
     * Calculates the total number of calories of all candies in the gift.
     *
     * @return the total calories
     */
    public double getTotalCalories() {
        double total = 0.0;
        for (Candy candy : candies) {
            total += candy.getCalories();
        }
        return total;
    }
    /**
     * Sorts candies in the gift using the specified comparator.
     *
     * @param comparator the comparator defining the sorting rule
     * @throws IllegalArgumentException if the comparator is {@code null}
     */
    public void sortBy(Comparator<Candy> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null.");
        }
        candies.sort(comparator);
    }
    /**
     * Finds candies in which chocolate content falls within a given range.
     *
     * @param min the minimum chocolate percentage
     * @param max the maximum chocolate percentage
     * @return a list of candies with chocolate content in the range [min, max]
     * @throws IllegalArgumentException if the range is invalid
     */
    public List<Candy> findByChocolateRange(double min, double max) {
        if (min < 0 || max > 100 || min > max) {
            throw new IllegalArgumentException("Invalid chocolate range.");
        }

        List<Candy> result = new ArrayList<>();
        for (Candy candy : candies) {
            double percent = candy.getChocolatePercent();
            if (percent >= min && percent <= max) {
                result.add(candy);
            }
        }
        return result;
    }
    /**
     * Returns a copy of the list of candies in this gift.
     *
     * @return a list of candies
     */
    public List<Candy> getCandies() {
        return new ArrayList<>(candies);
    }
    /**
     * Returns a string representation of this gift.
     *
     * @return a string listing all candies and total values
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Gift contents:\n");
        for (Candy candy : candies) {
            sb.append(" - ").append(candy).append("\n");
        }
        sb.append(String.format("Total price: %.2f", getTotalPrice()));
        sb.append(String.format("Total weight: %.2f g", getTotalWeight()));
        sb.append(String.format("Total calories: %.2f g", getTotalCalories()));

        return sb.toString();
    }
}
