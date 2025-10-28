/**
 * Represents a caramel candy with an optional filling.
 *
 * <p>This class extends {@link Candy} by adding information
 * about the filling type, which can be "liquid" or "solid" as an example.</p>
 */
public class CaramelCandy extends Candy {
    /** The type of filling inside the candy*/
    private final String fillingType;
    /**
     * Constructs a {@code CaramelCandy} with the specified parameters.
     *
     * @param name             the name of the candy
     * @param weight           the weight in grams
     * @param price            the price of the candy
     * @param calories         the caloric value of the candy
     * @param chocolatePercent the chocolate content percentage (0–100)
     * @param fillingType      the type of filling (e.g., "liquid", "solid")
     */
    public CaramelCandy(String name, double weight, double price, double calories, double chocolatePercent, String fillingType) {
        super(name, weight, price, calories, chocolatePercent);
        this.fillingType = fillingType;
    }
    /**
     * Returns the filling type of this caramel candy.
     *
     * @return the filling type
     */
    public String getFillingType() {
        return fillingType;
    }
    /**
     * Returns a string representation of this caramel candy.
     *
     * @return a string with all candy properties
     */
    @Override
    public String toString() {
        return super.toString() + ", fillingType=" + fillingType;
    }
}
