/**
 * Represents a word consisting of letters.
 */
public class Word {
    private final Letter[] letters;

    /**
     * Constructs a Word from a string.
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
    public String getText() {
        String result = "";
        for (Letter letter : letters) {
            result += letter.getValue();
        }
        return result;
    }

    @Override
    public String toString() {
        return getText();
    }
}
