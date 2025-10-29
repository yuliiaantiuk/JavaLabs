/**
 * Sorts sentences in ascending order by the number of words in it
 *
 * <p>
 * The program builds a {@link Text} object from a predefined string
 * and prints all sentences sorted by their word count.
 * </p>
 */
public class SentenceSorter2 {
    /**
     * The entry point of the program.
     * <p>
     * Initializes a sample text, constructs a {@link Text} instance,
     * and outputs the sorted sentences with their word counts.
     * </p>
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            String text = "Is programming fun? Java was        created in the 1990s and has remained popular ever since. Java is one of the most widely used languages.\n" +
                    "Some people find Java easier to learn than C++, while others prefer Python.  Developers use Java to build web applications, desktop software, and mobile apps.\n" +
                    "Although new languages appear    every year, Java continues to play an important role in software development worldwide. Large companies rely on Java because of its stability and scalability.\n" +
                    "The quick brown fox    jumps over the lazy dog! It is just an     additional sentence for testing!";

            Text t = new Text(text);
            t.printSortedByWordCount();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}