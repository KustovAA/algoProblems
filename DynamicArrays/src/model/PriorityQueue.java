package model;

import java.util.HashMap;

public class PriorityQueue<T> {
    private final VectorArray<Queue<T>> priorityList;
    private final VectorArray<Integer> priorities;

    public PriorityQueue() {
        priorityList = new VectorArray<>();
        priorities = new VectorArray<>();
    }

    public void enqueue(int priority, T item) {
        Queue<T> queue = null;
        int leftPriority = 0;
        int rightPriority = Math.max(priorities.size() - 1, 0);
        int curPriority = -1;

        for (int i = 0; i < priorities.size(); i++) {
            if (priority == priorities.get(i)) {
                curPriority = i;
                break;

            } else if (priority > priorities.get(i)) {
                leftPriority = i;

            } else {
                rightPriority = Math.max(i, 1);
                break;
            }
        }

        if (curPriority != -1) {
            queue = priorityList.get(curPriority);

        } else if (leftPriority == rightPriority) {
            priorityList.add(new Queue<>());
            priorities.add(priority);
            queue = priorityList.get(priorities.size() - 1);

        } else {
            priorities.add(priority, leftPriority);
            priorityList.add(new Queue<>(), leftPriority);
            queue = priorityList.get(leftPriority);
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
