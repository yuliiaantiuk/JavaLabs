import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Gift {
    private final List<Candy> candies;
    public Gift() {
        this.candies = new ArrayList<>();
    }
    public void addCandy(Candy candy) {
        if (candy == null) {
            throw new IllegalArgumentException("Candy cannot be null.");
        }
        candies.add(candy);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Candy candy : candies) {
            total += candy.getPrice();
        }
        return total;
    }

    public double getTotalWeight() {
        double total = 0.0;
        for (Candy candy : candies) {
            total += candy.getWeight();
        }
        return total;
    }

    public double getTotalCalories() {
        double total = 0.0;
        for (Candy candy : candies) {
            total += candy.getCalories();
        }
        return total;
    }

    public void sortBy(Comparator<Candy> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null.");
        }
        candies.sort(comparator);
    }

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

    public List<Candy> getSweets() {
        return new ArrayList<>(candies);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Gift contents:\n");
        for (Candy sweet : candies) {
            sb.append(" - ").append(sweet).append("\n");
        }
        sb.append(String.format("Total price: %.2f", getTotalPrice()));
        sb.append(String.format("Total weight: %.2f g", getTotalWeight()));
        sb.append(String.format("Total calories: %.2f g", getTotalCalories()));

        return sb.toString();
    }
}
