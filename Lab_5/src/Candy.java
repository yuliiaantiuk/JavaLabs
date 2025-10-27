/**
 * Abstract base class representing a candy.
 *
 * <p>This class serves as a general blueprint for various types of sweets,
 * such as chocolate candies, or caramel candies or lollipops. It defines the common
 * properties and behavior shared by all sweet types.</p>
 *
 */
public abstract class Candy {
    /** The name of the candy. */
    private final String name;

    /** The weight of the sweet in grams. */
    private final double weight;

    /** The price of the sweet. */
    private final double price;

    /** The energy value of the candy in calories. */
    private final double calories;

    /** The percentage of chocolate content (0 to 100). */
    private final double chocolatePercent;

    public Candy(String name, double weight, double price, double calories, double chocolatePercent) {
        if (weight < 0 || price < 0 || calories < 0) {
            throw new IllegalArgumentException("Weight, price, and calories must be non-negative.");
        }
        if (chocolatePercent < 0 || chocolatePercent > 100) {
            throw new IllegalArgumentException("Chocolate percent must be between 0 and 100.");
        }

        this.name = name;
        this.weight = weight;
        this.price = price;
        this.calories = calories;
        this.chocolatePercent = chocolatePercent;
    }

    /**
     * Returns the name of the sweet.
     *
     * @return the sweet's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the weight of the sweet in grams.
     *
     * @return the sweet's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the price of the sweet.
     *
     * @return the sweet's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the caloric content of the sweet.
     *
     * @return the sweet's calories
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Returns the chocolate content percentage.
     *
     * @return the chocolate percentage (0–100)
     */
    public double getChocolatePercent() {
        return chocolatePercent;
    }

    /**
     * Returns a string representation of this sweet.
     *
     * @return a string containing all main properties of the sweet
     */
    @Override
    public String toString() {
        return String.format("%s [weight=%.2fg, price=%.2f, calories=%.1f, chocolate=%.1f%%]",
                name, weight, price, calories, chocolatePercent);
    }

    /**
     * Compares this sweet with another object for equality.
     *
     * @param obj the object to compare
     * @return {@code true} if the objects are equal, {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Candy)) return false;
        Candy other = (Candy) obj;
        return name.equals(other.name)
                && Double.compare(weight, other.weight) == 0
                && Double.compare(price, other.price) == 0
                && Double.compare(calories, other.calories) == 0
                && Double.compare(chocolatePercent, other.chocolatePercent) == 0;
    }

    /**
     * Returns the hash code for this sweet.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Double.hashCode(weight);
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + Double.hashCode(calories);
        result = 31 * result + Double.hashCode(chocolatePercent);
        return result;
    }
}
