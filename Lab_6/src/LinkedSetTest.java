import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class LinkedSetTest {
    @Test
    void testEmptyConstructor() {
        LinkedSet<Candy> candySet = new LinkedSet<>();

        assertTrue(candySet.isEmpty(), "Set should be empty after default constructor");
        assertEquals(0, candySet.size(), "Size should be 0 after default constructor");
    }

    @Test
    void testSingleElementConstructor() {
        ChocolateCandy truffle = new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true);
        LinkedSet<Candy> candySet = new LinkedSet<>(truffle);

        assertTrue(candySet.contains(truffle), "Set should contain " + truffle.toString());
        assertEquals(1, candySet.size(), "Size should be 1 after single element constructor");
        assertFalse(candySet.isEmpty(), "Set should not be empty after adding candies");
    }

    @Test
    void testMultipleElementConstructor() {
        List<Candy> gift = new ArrayList<>();

        gift.add(new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true));
        gift.add(new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false));
        gift.add(new ChocolateCandy("Dark Bliss", 20, 85.0, 140, 85, false));
        gift.add(new CaramelCandy("Wether's", 15, 73.3, 200, 10, "liquid"));
        gift.add(new CaramelCandy("Duchess", 18, 86.4, 120, 7, "solid"));
        gift.add(new Lollipop("Chupa Chups", 21, 94.6, 83, 0, "apple"));
        gift.add(new Lollipop("Chupa Chups", 20, 98.6, 82, 0, "cherry"));

        LinkedSet<Candy> candySet = new LinkedSet<>(gift);

        assertEquals(gift.size(), candySet.size(), "Set should contain same number of elements as input list");
        for (Candy c : gift) {
            assertTrue(candySet.contains(c), "Set should contain candy: " + c.toString());
        }
        Candy duplicate = gift.get(0);
        boolean addedAgain = candySet.add(duplicate);
        assertFalse(addedAgain, "Duplicate candy should not be added to the set");

        assertFalse(candySet.isEmpty(), "Set should not be empty after adding candies");
    }

    @Test
    void testAdd(){
        LinkedSet<Candy> candySet = new LinkedSet<>();
        ChocolateCandy testCandy = new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false);
        candySet.add(testCandy);
        assertTrue(candySet.contains(testCandy), "Set should contain candy: " + testCandy.toString());
        assertFalse(candySet.isEmpty(), "Set should not be empty after adding candies");
        assertFalse(candySet.add(testCandy), "Set should not add duplicates: ");
    }

    @Test
    void testRemoveStart(){
        List<Candy> gift = new ArrayList<>();

        gift.add(new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true));
        gift.add(new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false));
        gift.add(new ChocolateCandy("Dark Bliss", 20, 85.0, 140, 85, false));
        gift.add(new CaramelCandy("Wether's", 15, 73.3, 200, 10, "liquid"));
        gift.add(new CaramelCandy("Duchess", 18, 86.4, 120, 7, "solid"));
        gift.add(new Lollipop("Chupa Chups", 21, 94.6, 83, 0, "apple"));
        gift.add(new Lollipop("Chupa Chups", 20, 98.6, 82, 0, "cherry"));

        LinkedSet<Candy> candySet = new LinkedSet<>(gift);

        int initialSize = candySet.size();
        Candy firstCandy = gift.get(0);

        assertTrue(candySet.remove(firstCandy), "Set should remove first candy: " + firstCandy.toString());
        assertEquals(initialSize - 1, candySet.size(), "Set size should decrease by 1 after removal");
        assertFalse(candySet.contains(firstCandy), "Removed element should no longer be in the set");
    }

    @Test
    void testRemoveMiddle(){
        List<Candy> gift = new ArrayList<>();

        gift.add(new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true));
        gift.add(new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false));
        gift.add(new ChocolateCandy("Dark Bliss", 20, 85.0, 140, 85, false));
        gift.add(new CaramelCandy("Wether's", 15, 73.3, 200, 10, "liquid"));
        gift.add(new CaramelCandy("Duchess", 18, 86.4, 120, 7, "solid"));
        gift.add(new Lollipop("Chupa Chups", 21, 94.6, 83, 0, "apple"));
        gift.add(new Lollipop("Chupa Chups", 20, 98.6, 82, 0, "cherry"));

        LinkedSet<Candy> candySet = new LinkedSet<>(gift);

        int initialSize = candySet.size();
        Candy middleCandy = gift.get(3);

        assertTrue(candySet.remove(middleCandy), "Set should remove middle candy: " + middleCandy.toString());
        assertEquals(initialSize - 1, candySet.size(), "Set size should decrease by 1 after removal");
        assertFalse(candySet.contains(middleCandy), "Removed element should no longer be in the set");
    }

    @Test
    void testRemoveLast(){
        List<Candy> gift = new ArrayList<>();

        gift.add(new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true));
        gift.add(new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false));
        gift.add(new ChocolateCandy("Dark Bliss", 20, 85.0, 140, 85, false));
        gift.add(new CaramelCandy("Wether's", 15, 73.3, 200, 10, "liquid"));
        gift.add(new CaramelCandy("Duchess", 18, 86.4, 120, 7, "solid"));
        gift.add(new Lollipop("Chupa Chups", 21, 94.6, 83, 0, "apple"));
        gift.add(new Lollipop("Chupa Chups", 20, 98.6, 82, 0, "cherry"));

        LinkedSet<Candy> candySet = new LinkedSet<>(gift);

        int initialSize = candySet.size();
        Candy lastCandy = gift.get(gift.size() - 1);

        assertTrue(candySet.remove(lastCandy), "Set should remove last candy: " + lastCandy.toString());
        assertEquals(initialSize - 1, candySet.size(), "Set size should decrease by 1 after removal");
        assertFalse(candySet.contains(lastCandy), "Removed element should no longer be in the set");
    }
}
