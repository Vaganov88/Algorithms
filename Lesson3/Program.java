public class Program {
    public static void main(String[] args) {
        MyArrayDeque<Character> deque = new MyArrayDeque<>();
        deque.insertLeft('a');
        deque.insertLeft('b');
        deque.insertLeft('c');
        deque.insertLeft('d');
        deque.insertRight('e');
        deque.insertRight('f');
        deque.insertRight('g');
        deque.insertRight('h');
        System.out.println(deque);
        deque.removeLeft();
        deque.removeLeft();
        deque.removeRight();
        System.out.println(deque);
        deque.removeRight();
        deque.removeRight();
        System.out.println(deque);
    }
}
