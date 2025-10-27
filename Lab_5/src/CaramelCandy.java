public class CaramelCandy extends Candy {
    private final String fillingType;

    public CaramelCandy(String name, double weight, double price, double calories, double chocolatePercent, String fillingType) {
        super(name, weight, price, calories, chocolatePercent);
        this.fillingType = fillingType;
    }
    public String getFillingType() {
        return fillingType;
    }
    @Override
    public String toString() {
        return super.toString() + ", fillingType=" + fillingType;
    }
}
