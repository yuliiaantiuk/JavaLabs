/**
 * Represents a sentence consisting of {@link Word} and {@link Punctuation} objects.
 * <p>
 * A {@code Sentence} is constructed by parsing a string into words and punctuation marks.
 * Words and punctuation marks are stored separately in corresponding arrays.
 * </p>
 */
public class Sentence {
    /** The words in the sentence */
    private final Word[] words;
    /** The punctuation marks in the sentence */
    private final Punctuation[] punctuations;

    /**
     * Constructs a {@code Sentence} from a given string.
     * <p>
     * The constructor normalizes spaces and separates words from punctuation
     * using regular expressions.
     * </p>
     *
     * @param sentence the sentence text
     */
    public Sentence(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ").trim();

        String[] parts = sentence.split("(?=[.,!?])|\\s+");

        int wordCount = 0, punctCount = 0;
        for (String p : parts) {
            if (p.matches("[.,!?]")) punctCount++;
            else if (!p.isBlank()) wordCount++;
        }

        words = new Word[wordCount];
        punctuations = new Punctuation[punctCount];

        int wi = 0, pi = 0;
        for (String p : parts) {
            if (p.matches("[.,!?]")) {
                punctuations[pi++] = new Punctuation(p);
            } else if (!p.isBlank()) {
                words[wi++] = new Word(p);
            }
        }
    }

    /**
     * Returns the number of words in this sentence.
     *
     * @return number of words
     */
    public int getWordCount() {
        return words.length;
    }
    /**
     * Returns the string representation of this sentence.
     *
     * @return the full text of the sentence
     */
    @Override
    public String toString() {
        String result = "";
        for (Word w : words) {
            result += w.toString() + " ";
        }
        for (Punctuation p : punctuations) {
            result += p.getSymbol();
        }
        return result.trim();
    }
}
