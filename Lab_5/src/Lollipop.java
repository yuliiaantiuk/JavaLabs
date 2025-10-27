public class Lollipop extends Candy {
    private final String flavour;
    public Lollipop(String name, double weight, double price, double calories, double chocolatePercent, String flavour) {
        super(name, weight, price, calories, chocolatePercent);
        this.flavour = flavour;
    }
    public String getFlavour() {
        return flavour;
    }
    @Override
    public String toString() {
        return super.toString() + ", flavour=" + flavour;
    }
}
