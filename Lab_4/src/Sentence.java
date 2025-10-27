/**
 * Represents a sentence consisting of words and punctuation marks.
 */
public class Sentence {
    private final Word[] words;
    private final Punctuation[] punctuations;

    /**
     * Constructs a Sentence from a string.
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
     * Returns the full text of the sentence.
     *
     * @return text of the sentence
     */
    public String getText() {
        String result = "";
        for (Word w : words) {
            result += w.getText() + " ";
        }
        for (Punctuation p : punctuations) {
            result += p.getSymbol();
        }
        return result.trim();
    }

    @Override
    public String toString() {
        return getText();
    }
}
