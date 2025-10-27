import java.util.Arrays;
import java.util.Comparator;

/**
 * Represents a text consisting of sentences.
 */
public class Text {
    private final Sentence[] sentences;

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
            System.out.println(s.getWordCount() + " words - " + s.getText());
        }
    }
}
