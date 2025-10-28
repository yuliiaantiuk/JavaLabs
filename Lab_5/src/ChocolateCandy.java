/**
 * Represents a chocolate candy, optionally containing nuts.
 *
 * <p>This class extends {@link Candy} and adds a boolean property
 * indicating if the candy contains nuts.</p>
 */
public class ChocolateCandy extends Candy {
    /** Indicates if the candy contains nuts. */
    private final boolean withNuts;
    /**
     * Constructs a {@code ChocolateCandy} with the specified parameters.
     *
     * @param name             the name of the candy
     * @param weight           the weight in grams
     * @param price            the price of the candy
     * @param calories         the caloric value of the candy
     * @param chocolatePercent the chocolate content percentage (0–100)
     * @param withNuts         {@code true} if the candy contains nuts, {@code false} otherwise
     */
    public ChocolateCandy(String name, int weight, double price, double calories, double chocolatePercent, boolean withNuts) {
        super(name, weight, price, calories, chocolatePercent);
        this.withNuts = withNuts;
    }
    /**
     * Returns whether the candy contains nuts.
     *
     * @return {@code true} if the candy contains nuts, {@code false} otherwise
     */
    public boolean isWithNuts() {
        return withNuts;
    }
    /**
     * Returns a string representation of this chocolate candy.
     *
     * @return a string with all candy properties
     */
    @Override
    public String toString() {
        return super.toString() + ", withNuts=" + withNuts;
    }
}
