import java.util.Objects;

/**
 * Represents a car with basic properties such as brand, model, year,
 * price, and mileage.
 */
public class Car {
    /** The brand of the car */
    private final String brand;
    /** The model of the car */
    private final String model;
    /** The year of manufacture of the car */
    private final int year;
    /** The price of the car */
    private final double price;
    /** The car mileage in kilometers */
    private final int mileage;

    /**
     * Constructs a new {@code Car} with the specified parameters.
     *
     * @param brand   the car brand
     * @param model   the car model
     * @param year    the year of manufacture
     * @param price   the car price
     * @param mileage the car mileage in kilometers
     */
    public Car(String brand, String model, int year, double price, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.mileage = mileage;
    }

    /**
     * Returns the brand of the car.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns the model of the car.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the manufacture year of the car.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the price of the car.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the mileage of the car in kilometers.
     *
     * @return the mileage
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * Returns a string representation of the car object.
     *
     * @return a string describing this car
     */
    @Override
    public String toString() {
        return String.format("%s %s (year=%d, price=%.2f, mileage=%d)",
                brand, model, year, price, mileage);
    }

    /**
     * Returns whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument,
     *         {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year
                && mileage == car.mileage
                && Double.compare(car.price, price) == 0
                && Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model);
    }

    /**
     * Returns a hash code value for the car.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, price, mileage);
    }
}
