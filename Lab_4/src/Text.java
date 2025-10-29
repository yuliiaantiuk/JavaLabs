import java.util.Arrays;
import java.util.Comparator;

/**
 * Represents a text consisting of multiple {@link Sentence} objects.
 * <p>
 * The text is split into sentences based on punctuation marks ('.', '!', '?').
 * This class also provides functionality to sort and print sentences by the number of words they contain.
 * </p>
 */
public class Text {
    /** Array of sentences */
    private final Sentence[] sentences;
    /**
     * Constructs a {@code Text} object from a string.
     * <p>
     * The text is split into individual sentences using punctuation delimiters.
     * </p>
     *
     * @param text the full text string
     */
    public Text(String text) {
        text = text.replaceAll("\\s+", " ").trim();
        String[] sentenceStrings = text.split("(?<=[.!?])\\s*");
        sentences = new Sentence[sentenceStrings.length];
        for (int i = 0; i < sentenceStrings.length; i++) {
            sentences[i] = new Sentence(sentenceStrings[i]);
        }
    }

    /**
     * Prints all sentences sorted by number of words ascending.
     */
    public void printSortedByWordCount() {
        Sentence[] sorted = Arrays.copyOf(sentences, sentences.length);
        Arrays.sort(sorted, Comparator.comparingInt(Sentence::getWordCount));

        for (Sentence s : sorted) {
            System.out.println(s.getWordCount() + " words - " + s.toString());
        }
    }
}
