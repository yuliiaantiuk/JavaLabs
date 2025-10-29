/**
 * Represents a word consisting of individual {@link Letter} objects.
 * <p>
 * Each {@code Word} is constructed by splitting a string into separate
 * {@code Letter} instances. The class provides a method to reconstruct the full text of the word.
 * </p>
 */
public class Word {
    private final Letter[] letters;

    /**
     * Constructs a {@code Word} from a string.
     *
     * @param word the word as a string
     */
    public Word(String word) {
        String[] chars = word.split("");
        letters = new Letter[chars.length];
        for (int i = 0; i < chars.length; i++) {
            letters[i] = new Letter(chars[i]);
        }
    }

    /**
     * Returns the word text (concatenation of letters).
     *
     * @return the word as string
     */
    @Override
    public String toString() {
        String result = "";
        for (Letter letter : letters) {
            result += letter.getValue();
        }
        return result;
    }
}
