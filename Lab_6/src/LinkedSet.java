import java.util.*;

public class LinkedSet<T> implements Set<T> {
    private static class Node<E> {
        E value;
        Node<E> next;
        Node(E v, Node<E> n) { value = v; next = n; }
    }

    private Node<T> head;
    private int size;
    private int modCount;

    public LinkedSet() {
        head = null;
        size = 0;
        modCount = 0;
    }

    public LinkedSet(T element) {
        this();
        add(element);
    }

    public LinkedSet(Collection<? extends T> c) {
        this();
        if (c == null) throw new NullPointerException("Collection is null");
        for (T e : c) add(e);
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
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

    @Override
    public boolean contains(Object element) {
        for (Node<T> current = head; current != null; current = current.next) {
            if (Objects.equals(current.value, element)) {
                return true;
            }
        }
        return false;
    }

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

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Node<T> current = head; current != null; current = current.next) {
            arr[i++] = current.value;
        }
        return arr;
    }
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
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e)) return false;
        return true;
    }
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for (T e : c)
            if (add(e)) changed = true;
        return changed;
    }
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
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object e : c)
            if (remove(e)) changed = true;
        return changed;
    }
    @Override
    public void clear() {
        head = null;
        size = 0;
        modCount++;
    }
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
