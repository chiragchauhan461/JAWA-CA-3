// LeetCode 1114 - Print in Order
// Java focus: Thread, Runnable, synchronization, join, thread lifecycle
class LC1114_PrintInOrder {
    private int step = 1;

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        while (step != 1) {
            wait();
        }
        printFirst.run();
        step = 2;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (step != 2) {
            wait();
        }
        printSecond.run();
        step = 3;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (step != 3) {
            wait();
        }
        printThird.run();
        step = 4;
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        LC1114_PrintInOrder order = new LC1114_PrintInOrder();

        Thread third = new Thread(() -> {
            try { order.third(() -> System.out.print("third ")); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread second = new Thread(() -> {
            try { order.second(() -> System.out.print("second ")); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread first = new Thread(() -> {
            try { order.first(() -> System.out.print("first ")); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });

        third.start();
        second.start();
        first.start();

        first.join();
        second.join();
        third.join();
        System.out.println();
    }
}
