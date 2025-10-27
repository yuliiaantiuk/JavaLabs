/**
 * Represents a punctuation mark.
 */
public class Punctuation {
    private final String symbol;

    public Punctuation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
