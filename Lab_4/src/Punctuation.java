/**
 * Represents a punctuation mark in a sentence.
 * <p>
 * This class represents a single punctuation symbol (such as '.', ',', '?', '!').
 * Instances of this class are immutable.
 * </p>
 */
public class Punctuation {
    /** A punctuation symbol */
    private final String symbol;

    /**
     * Constructs a {@code Punctuation} instance with the specified symbol.
     *
     * @param symbol the punctuation symbol (e.g., ".", ",", "!", "?")
     */
    public Punctuation(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the punctuation symbol represented by this object.
     *
     * @return the punctuation symbol as a string
     */
    public String getSymbol() {
        return symbol;
    }
}
