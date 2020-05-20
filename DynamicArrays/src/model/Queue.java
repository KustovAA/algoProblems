package model;

public class Queue<T> {
    Node<T> head;
    Node<T> tail;

    public Queue() {
        head = tail = null;
    }

    public void enqueue(T item) {
        if (head == null) {
            head = tail = new Node<T>(item, null);
            return;
        }

        tail.setNext(new Node<T>(item, null));
        tail = tail.getNext();
    }

    public T dequeue() {
        T result = head.getValue();
        head = head.getNext();
        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
