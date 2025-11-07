import java.util.*;
/**
 * A custom implementation of the {@link Set} interface based on a singly linked list.
 * <p>
 * This implementation does not allow duplicate elements and does not maintain
 * any particular order of elements. It provides basic set operations such as
 * adding, removing, checking containment, and iteration.
 * </p>
 *
 * @param <T> the type of elements maintained by this set
 */
public class LinkedSet<T> implements Set<T> {
    /**
     * A node in the singly linked list representing one element of the set.
     *
     * @param <E> the type of element stored in the node
     */
    private static class Node<E> {
        /** The stored element value. */
        E value;
        /** The reference to the next node in the list. */
        Node<E> next;
        /**
         * Constructs a new node with the given value and next node reference.
         *
         * @param v the value to store
         * @param n the reference to the next node
         */
        Node(E v, Node<E> n) {
            value = v;
            next = n;
        }
    }
    /** The head node of the linked list. */
    private Node<T> head;
    /** The number of elements in this set. */
    private int size;
    /** The number of times this set has been structurally modified. */
    private int modCount;
    /**
     * Constructs an empty {@code LinkedSet}.
     */
    public LinkedSet() {
        head = null;
        size = 0;
        modCount = 0;
    }
    /**
     * Constructs a {@code LinkedSet} containing the specified single element.
     *
     * @param element the element to add to this set
     */
    public LinkedSet(T element) {
        this();
        add(element);
    }
    /**
     * Constructs a {@code LinkedSet} containing all elements from the specified collection.
     *
     * @param c the collection whose elements are to be placed into this set
     * @throws NullPointerException if the specified collection is {@code null}
     */
    public LinkedSet(Collection<? extends T> c) {
        this();
        if (c == null) throw new NullPointerException("Collection is null");
        for (T e : c) add(e);
    }
    /**
     * {@inheritDoc}
     * Returns the size of the set.
     *
     * @return The size of the set.
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * {@inheritDoc}
     * Returns if the set is empty.
     *
     * @return {@code true} if the set is empty, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * {@inheritDoc}
     * Adds the specified element to the beginning of the set.
     * <p>Elements are stored in reverse insertion order (new elements appear first).</p>
     *
     * @return {@code true} if the element was added successfully, {@code false} otherwise.
     */
    @Override
    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        head = new Node<>(element, head);
        size++;
        modCount++;
        return true;
    }
    /**
     * {@inheritDoc}
     * Removes the specified element from the set.
     *
     * @return {@code true} if the element was removed successfully, {@code false} otherwise.
     */
    @Override
    public boolean remove(Object element) {
        if (head == null) return false;

        if (Objects.equals(head.value, element)) {
            head = head.next;
            size--;
            modCount++;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.value, element)) {
                current.next = current.next.next;
                size--;
                modCount++;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    /**
     * {@inheritDoc}
     * Returns if the set contains the specified element
     *
     * @return {@code true} if the set contains the specified element, {@code false} otherwise.
     */
    @Override
    public boolean contains(Object element) {
        for (Node<T> current = head; current != null; current = current.next) {
            if (Objects.equals(current.value, element)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns an iterator over the elements in this set.
     * <p>
     * The iterator does not support modification of the set during iteration.
     * If the set is modified while iterating, a {@link ConcurrentModificationException} is thrown.
     * </p>
     *
     * @return an iterator over the elements in this set
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (modCount != expectedModCount)
                    throw new ConcurrentModificationException("LinkedSet modified during iteration");
                if (current == null)
                    throw new NoSuchElementException();

                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
    /**
     * {@inheritDoc}
     * Returns an array containing all the elements in this set in the order
     * they are stored internally.
     *
     * <p>The elements are returned in insertion order.</p>
     *
     * @return an array containing all elements of the set
     */
    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node<T> current = head; current != null; current = current.next) {
            arr[i++] = current.value;
        }
        return arr;
    }
    /**
     * {@inheritDoc}
     * Returns an array containing all the elements in this set.
     *
     * <p>If the provided array is large enough, the elements are stored
     * in it. Otherwise, a new array of the same runtime type is created.</p>
     *
     * <p>If the array is larger than the size of the set, the element immediately
     * following the last set element is set to {@code null}.</p>
     *
     * @param <E> the runtime type of the returned array.
     *
     * @throws NullPointerException if the specified array is {@code null}
     *
     * @return an array containing all elements of the set
     */
    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a == null) throw new NullPointerException("Array is null");
        if (a.length < size)
            a = (E[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);

        int i = 0;
        Object[] result = a;
        for (Node<T> current = head; current != null; current = current.next)
            result[i++] = current.value;

        if (a.length > size)
            a[size] = null;

        return a;
    }
    /**
     * {@inheritDoc}
     *
     * Checks whether this set contains every element in the specified
     * collection by iterating over the collection and calling {@link #contains(Object)}
     * for each element.
     *
     * @param c the collection to check for containment
     * @return {@code true} if this set contains all elements from the given collection
     * @throws NullPointerException if the specified collection is {@code null}
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) throw new NullPointerException("Collection is null");
        for (Object e : c)
            if (!contains(e)) return false;
        return true;
    }
    /**
     * {@inheritDoc}
     *
     * Adds all the elements from the specified collection to this set.
     * <p>Duplicate elements (determined by {@code equals}) are ignored.</p>
     *
     * @param c the collection containing elements to be added
     * @return {@code true} if at least one element was added
     * @throws NullPointerException if the specified collection is {@code null}
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null) throw new NullPointerException("Collection is null");
        boolean changed = false;
        for (T e : c)
            if (add(e)) changed = true;
        return changed;
    }
    /**
     * {@inheritDoc}
     *
     * Retains only the elements in this set that are contained in the specified
     * collection. Elements not present in the collection are removed.
     *
     * <p>This method iterates over the set and removes nodes not found in the
     * specified collection, updating internal size and modification count.</p>
     *
     * @param c the collection containing elements to retain
     * @return {@code true} if the set was modified
     * @throws NullPointerException if the specified collection is {@code null}
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) throw new NullPointerException("Collection is null");
        boolean changed = false;
        Node<T> current = head;
        Node<T> prev = null;

        while (current != null) {
            if (!c.contains(current.value)) {
                if (prev == null) head = current.next;
                else prev.next = current.next;
                size--;
                changed = true;
            } else {
                prev = current;
            }
            current = current.next;
        }
        if (changed) modCount++;
        return changed;
    }
    /**
     * {@inheritDoc}
     *
     * Removes from this set all elements that are contained in the specified
     * collection.
     *
     * <p>Each element in the collection is removed using {@link #remove(Object)}.</p>
     *
     * @param c the collection containing elements to be removed
     * @return {@code true} if the set was modified
     * @throws NullPointerException if the specified collection is {@code null}
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) throw new NullPointerException("Collection is null");
        boolean changed = false;
        for (Object e : c)
            if (remove(e)) changed = true;
        return changed;
    }
    /**
     * {@inheritDoc}
     *
     * Clears the set
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
        modCount++;
    }
    /**
     * Returns a string representation of this set.
     * <p>
     * The format is {@code [element1, element2, ...]}.
     * </p>
     *
     * @return a string containing all elements of this set
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
}
