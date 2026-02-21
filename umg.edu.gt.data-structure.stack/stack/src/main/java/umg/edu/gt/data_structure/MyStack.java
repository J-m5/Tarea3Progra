package umg.edu.gt.data_structure;

public class MyStack<T> {

    private Node<T> top;
    private int count;

    public MyStack() {
        this.top = null;
        this.count = 0;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = top;
        top = node;
        count++;
    }

    public T pop() {
        if (isEmpty()) return null;

        T value = top.data;
        top = top.next;
        count--;
        return value;
    }

    public T peek() {
        if (isEmpty()) return null;
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getCount() {
        return count;
    }

    public int getSize() {
        return count;
    }

    public Node<T> getNodeInit() {
        if (top == null) return null;

        Node<T> current = top;
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }
}