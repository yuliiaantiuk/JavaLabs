/**
 * Represents a lollipop with a specific flavour.
 *
 * <p>This class extends {@link Candy} by adding a flavour property,
 * such as "apple", "cherry", or "cola".</p>
 */
public class Lollipop extends Candy {
    /** The flavour of the lollipop.*/
    private final String flavour;
    /**
     * Constructs a {@code Lollipop} with the specified parameters.
     *
     * @param name             the name of the lollipop
     * @param weight           the weight in grams
     * @param price            the price of the lollipop
     * @param calories         the caloric value of the lollipop
     * @param chocolatePercent the chocolate content percentage (usually 0)
     * @param flavour          the flavour of the lollipop
     */
    public Lollipop(String name, double weight, double price, double calories, double chocolatePercent, String flavour) {
        super(name, weight, price, calories, chocolatePercent);
        this.flavour = flavour;
    }
    /**
     * Returns the flavour of this lollipop.
     *
     * @return the lollipop flavour
     */
    public String getFlavour() {
        return flavour;
    }
    /**
     * Returns a string representation of this lollipop.
     *
     * @return a string with all candy properties
     */
    @Override
    public String toString() {
        return super.toString() + ", flavour=" + flavour;
    }
}
