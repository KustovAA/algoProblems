package model;

import java.util.HashMap;

public class PriorityQueue<T> {
    private final VectorArray<Queue<T>> priorityList;

    public PriorityQueue() {
        priorityList = new VectorArray<Queue<T>>();
    }

    public void enqueue(int priority, T item) {
        Queue<T> queue = null;
        try {
            queue = priorityList.get(priority);
        } catch (ArrayIndexOutOfBoundsException e) {
            while (priorityList.size() <= priority + 1) {
                priorityList.add(new Queue<>());
            }
            queue = priorityList.get(priority);
        }

        queue.enqueue(item);
    }

    public T dequeue() {
        if (priorityList.size() == 0) {
            return null;
        }

        Queue<T> queue;
        for (int i = 0; i < priorityList.size(); i++) {
            if (!priorityList.get(i).isEmpty()) {
                return priorityList.get(i).dequeue();
            }
        }

        return null;
    }
}
