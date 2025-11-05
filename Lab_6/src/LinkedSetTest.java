import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit tests for the {@link LinkedSet} collection class using {@code Candy} objects.
 * <p>
 * This test suite verifies functionality including:
 * <ul>
 *     <li>Constructors (empty, single element, and from collection)</li>
 *     <li>Element addition and duplicate prevention</li>
 *     <li>Element removal</li>
 *     <li>Containment checks</li>
 *     <li>Iterator behavior and fail-fast modification detection</li>
 *     <li>Conversion to arrays</li>
 *     <li>Bulk operations (addAll, removeAll, retainAll)</li>
 *     <li>Clearing the set</li>
 *     <li>String representation</li>
 * </ul>
 * </p>
 */
public class LinkedSetTest {
    /** The list of {@code Candy} objects. */
    private List<Candy> gift;
    /** An empty {@code LinkedSet}. */
    private LinkedSet<Candy> candySet;
    /**
     * Initializes test data and populates a {@link LinkedSet} before each test.
     */
    @BeforeEach
    void setUp() {
        gift = createGift();
        candySet = new LinkedSet<>(gift);
    }
    /**
     * Creates a list of sample {@link Candy} objects for testing.
     *
     * @return predefined list of Candy elements
     */
    private List<Candy> createGift() {
        return Arrays.asList(
                new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true),
                new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false),
                new ChocolateCandy("Dark Bliss", 20, 85.0, 140, 85, false),
                new CaramelCandy("Wether's", 15, 73.3, 200, 10, "liquid"),
                new CaramelCandy("Duchess", 18, 86.4, 120, 7, "solid"),
                new Lollipop("Chupa Chups", 21, 94.6, 83, 0, "apple"),
                new Lollipop("Chupa Chups", 20, 98.6, 82, 0, "cherry")
        );
    }
    /**
     * Verifies that the empty constructor creates an empty set.
     */
    @Test
    void testEmptyConstructor() {
        LinkedSet<Candy> emptySet = new LinkedSet<>();

        assertTrue(emptySet.isEmpty());
        assertEquals(0, emptySet.size());
    }
    /**
     * Tests constructor that initializes the set with a single element.
     */
    @Test
    void testSingleElementConstructor() {
        Candy truffle = new ChocolateCandy("Truffle", 25, 72.2, 150, 70, true);
        LinkedSet<Candy> set = new LinkedSet<>(truffle);

        assertTrue(set.contains(truffle));
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
    }
    /**
     * Tests constructor that initializes from a collection and prevents duplicates.
     */
    @Test
    void testMultipleElementConstructor() {
        assertEquals(gift.size(), candySet.size());
        gift.forEach(c -> assertTrue(candySet.contains(c)));

        Candy duplicate = gift.get(0);
        assertFalse(candySet.add(duplicate));
        assertFalse(candySet.isEmpty());
    }
    /**
     * Validates {@link LinkedSet#add(Object)} behavior including duplicate rejection.
     */
    @Test
    void testAdd() {
        LinkedSet<Candy> set = new LinkedSet<>();
        Candy candy = new ChocolateCandy("Caramel Heart", 30, 100.5, 180, 50, false);

        assertTrue(set.add(candy));
        assertTrue(set.contains(candy));
        assertFalse(set.isEmpty());
        assertFalse(set.add(candy));
    }
    /**
     * Tests removal of first, middle, and last elements in the set.
     */
    @Test
    void testRemove() {
        int initialSize = candySet.size();

        // Test removing first, middle, last in one test
        Candy first = gift.get(0);
        Candy middle = gift.get(3);
        Candy last = gift.get(gift.size() - 1);

        assertTrue(candySet.remove(first));
        assertTrue(candySet.remove(middle));
        assertTrue(candySet.remove(last));

        assertEquals(initialSize - 3, candySet.size());
        assertFalse(candySet.contains(first));
        assertFalse(candySet.contains(middle));
        assertFalse(candySet.contains(last));
    }
    /**
     * Verifies that {@link LinkedSet#contains(Object)} works correctly.
     */
    @Test
    void testContains() {
        Candy exists = gift.get(4);
        Candy notExists = new Lollipop("Lollipop", 21, 94.6, 83, 0, "plum");

        assertTrue(candySet.contains(exists));
        assertFalse(candySet.contains(notExists));
    }
    /**
     * Ensures that the iterator visits all elements in the set.
     */
    @Test
    void testIteratorTraversesAllElements() {
        Iterator<Candy> it = candySet.iterator();
        List<Candy> result = new ArrayList<>();

        while (it.hasNext()) {
            result.add(it.next());
        }

        assertEquals(gift.size(), result.size());
        assertTrue(result.containsAll(gift));
    }
    /**
     * Ensures the iterator throws {@link ConcurrentModificationException}
     * when the set is modified during iteration.
     */
    @Test
    void testIteratorFailFastOnModification() {
        Iterator<Candy> it = candySet.iterator();
        candySet.add(new Lollipop("New", 10, 10, 10, 0, "berry"));

        assertThrows(ConcurrentModificationException.class, it::next);
    }
    /**
     * Tests {@link LinkedSet#toArray()} method.
     */
    @Test
    void testToArrayObject() {
        Object[] arr = candySet.toArray();

        assertEquals(gift.size(), arr.length);
        List<Object> resultList = Arrays.asList(arr);

        assertTrue(resultList.containsAll(gift));
        assertTrue(gift.containsAll(resultList));
    }
    /**
     * Tests typed array conversion when provided array is too small.
     */
    @Test
    void testToArrayTypedSmallerArray() {
        Candy[] arr = new Candy[1];
        Candy[] result = candySet.toArray(arr);

        List<Candy> expected = new ArrayList<>(gift);
        List<Candy> actual = Arrays.asList(result);

        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
        assertTrue(expected.containsAll(actual));

    }
    /**
     * Tests typed array conversion when provided array is larger.
     */
    @Test
    void testToArrayTypedLargerArray() {
        Candy[] arr = new Candy[gift.size() + 3];
        Candy[] result = candySet.toArray(arr);

        assertNull(result[gift.size()]);
        assertEquals(gift.size() + 3, result.length);
    }
    /**
     * Verifies {@link LinkedSet#containsAll(Collection)} behavior.
     */
    @Test
    void testContainsAll() {
        assertTrue(candySet.containsAll(gift));

        Collection<Candy> fake = List.of(
                new Lollipop("Lollipop", 5, 10, 10, 0, "orange")
        );
        assertFalse(candySet.containsAll(fake));
    }
    /**
     * Tests {@link LinkedSet#addAll(Collection)}.
     */
    @Test
    void testAddAll() {
        LinkedSet<Candy> set = new LinkedSet<>();
        assertTrue(set.addAll(gift));
        assertTrue(set.containsAll(gift));

        assertFalse(set.addAll(gift));
    }
    /**
     * Tests {@link LinkedSet#removeAll(Collection)}.
     */
    @Test
    void testRemoveAll() {
        List<Candy> toRemove = gift.subList(0, 3);
        assertTrue(candySet.removeAll(toRemove));

        for (Candy c : toRemove) {
            assertFalse(candySet.contains(c));
        }
    }
    /**
     * Tests {@link LinkedSet#retainAll(Collection)}.
     */
    @Test
    void testRetainAll() {
        List<Candy> toKeep = gift.subList(0, 2);
        assertTrue(candySet.retainAll(toKeep));

        assertEquals(toKeep.size(), candySet.size());
        assertTrue(candySet.containsAll(toKeep));
    }
    /**
     * Ensures {@link LinkedSet#clear()} empties the set and updates modCount.
     */
    @Test
    void testClear() {
        candySet.clear();

        assertTrue(candySet.isEmpty());
        assertEquals(0, candySet.size());
        assertFalse(candySet.contains(gift.get(0)));

        // clear має збільшувати modCount -> iterator after clear throws
        Iterator<Candy> it = candySet.iterator();
        candySet.add(gift.get(0));
        assertThrows(ConcurrentModificationException.class, it::next);
    }
    /**
     * Verifies {@link LinkedSet#toString()} includes expected structural format.
     */
    @Test
    void testToString() {
        String result = candySet.toString();
        assertTrue(result.startsWith("["));
        assertTrue(result.endsWith("]"));
        assertTrue(result.contains(gift.get(0).toString()));
    }

}
