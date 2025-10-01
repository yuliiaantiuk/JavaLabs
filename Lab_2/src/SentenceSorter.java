import java.util.Arrays;
import java.util.Comparator;

// C3 = 1; C17 = 1
public class SentenceSorter {
    public static void main(String[] args) {
        try {
            String text = "Is programming fun? Java was created in the 1990s and has remained popular ever since. Java is one of the most widely used languages." +
                    "Some people find Java easier to learn than C++, while others prefer Python.  Developers use Java to build web applications, desktop software, and mobile apps." +
                    "Although new languages appear every year, Java continues to play an important role in software development worldwide. Large companies rely on Java because of its stability and scalability." +
                    "The quick brown fox jumps over the lazy dog! It is just an additional sentence for testing!";

            // split text into sentences with .?!
            String[] sentences = text.split("(?<=[.!?])\\s*");

            // sort by the number of words
            Arrays.sort(sentences, Comparator.comparingInt(SentenceSorter::countWords));

            for (String sentence : sentences) {
                System.out.println(countWords(sentence) + " words - " + sentence.trim());
            }

        } catch (Exception e) {
            System.err.println("An error happened: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // method for counting the number of words in a sentence
    private static int countWords(String sentence) {
        if (sentence == null || sentence.isBlank()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }
}
