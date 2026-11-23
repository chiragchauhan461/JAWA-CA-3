// LeetCode 232 - Implement Queue using Stacks
// Java focus: interface + implementing class, composition, encapsulation
import java.util.ArrayDeque;
import java.util.Deque;

interface QueueOperations {
    void push(int value);
    int pop();
    int peek();
    boolean empty();
}

class LC232_ImplementQueueUsingStacks implements QueueOperations {
    private final Deque<Integer> inputStack = new ArrayDeque<>();
    private final Deque<Integer> outputStack = new ArrayDeque<>();

    @Override
    public void push(int value) {
        inputStack.push(value);
    }

    private void moveIfNeeded() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    @Override
    public int pop() {
        moveIfNeeded();
        return outputStack.pop();
    }

    @Override
    public int peek() {
        moveIfNeeded();
        return outputStack.peek();
    }

    @Override
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public static void main(String[] args) {
        LC232_ImplementQueueUsingStacks queue =
                new LC232_ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // 1
        System.out.println(queue.pop());   // 1
        System.out.println(queue.empty()); // false
    }
}
