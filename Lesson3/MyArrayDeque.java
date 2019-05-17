import java.util.NoSuchElementException;
public class MyArrayDeque <Item> {
    private Object[] deque = new Object[1];
    private int size = 0;
    private int start = 0; //left end
    private int end = 0;  //right end

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = deque[(start + i) % deque.length]; //x % n = [0, n - 1]
        }
        deque = tmp;
        start = 0;
        end = size;
    }

    public void insertRight(Item item) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        deque[end++] = item;
        end %= deque.length;
        size++;
    }

    public void insertLeft(Item item) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        start = (start - 1 + deque.length) % deque.length;
        deque[start] = item;
        size++;
    }

    public Item removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Item item = (Item) deque[start];
        deque[start] = null;
        size--;
        start = (start + 1) % deque.length;
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        end = (end - 1 + deque.length) % deque.length;
        Item item = (Item) deque[end];
        deque[end] = null;
        size--;
        if (size == deque.length / 4 && size > 0) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item peekLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (Item) deque[start];
    }

    public Item peekRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return (Item) deque[(end - 1 + deque.length) % deque.length];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(deque[(start + i) % deque.length] + ", ");
        }
        return s.toString();
    }
}
