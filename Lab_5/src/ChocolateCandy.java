public class ChocolateCandy extends Candy {
    private final boolean withNuts;

    public ChocolateCandy(String name, int weight, double price, double calories, double chocolatePercent, boolean withNuts) {
        super(name, weight, price, calories, chocolatePercent);
        this.withNuts = withNuts;
    }

    public boolean isWithNuts() {
        return withNuts;
    }
    @Override
    public String toString() {
        return super.toString() + ", withNuts=" + withNuts;
    }
}
