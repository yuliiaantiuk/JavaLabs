/**
 * Represents a single character (letter) in a word.
 */
public class Letter {
    /** The character value */
    private final String value;

    /**
     * Constructs a Letter with the given character.
     *
     * @param value the character value
     */
    public Letter(String value) {
        this.value = value;
    }

    /**
     * Returns the character value of this letter.
     *
     * @return the character value
     */
    public String getValue() {
        return value;
    }
}
