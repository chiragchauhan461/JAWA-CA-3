// LeetCode 622 - Design Circular Queue
// Java focus: constructor, private array, encapsulation, boolean return values
class LC622_DesignCircularQueue {
    private final int[] data;
    private final int capacity;
    private int front;
    private int size;

    public LC622_DesignCircularQueue(int k) {
        capacity = k;
        data = new int[k];
        front = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        int rear = (front + size) % capacity;
        data[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        int rear = (front + size - 1) % capacity;
        return data[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        LC622_DesignCircularQueue queue = new LC622_DesignCircularQueue(3);
        System.out.println(queue.enQueue(1)); // true
        System.out.println(queue.enQueue(2)); // true
        System.out.println(queue.Rear());     // 2
        System.out.println(queue.deQueue());  // true
        System.out.println(queue.Front());    // 2
    }
}
