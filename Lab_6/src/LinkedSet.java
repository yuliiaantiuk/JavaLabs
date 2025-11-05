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
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * {@inheritDoc}
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
     */
    @Override
    public boolean remove(Object element) {
        if (head == null) return false;

        // якщо елемент у голові списку
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
     */
    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
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
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e)) return false;
        return true;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for (T e : c)
            if (add(e)) changed = true;
        return changed;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection<?> c) {
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
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object e : c)
            if (remove(e)) changed = true;
        return changed;
    }
    /**
     * {@inheritDoc}
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
