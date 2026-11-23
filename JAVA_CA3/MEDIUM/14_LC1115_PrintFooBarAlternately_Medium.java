// LeetCode 1115 - Print FooBar Alternately
// Java focus: two threads, Runnable, synchronized, wait/notify
class LC1115_PrintFooBarAlternately {
    private final int n;
    private boolean fooTurn = true;

    public LC1115_PrintFooBarAlternately(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!fooTurn) {
                wait();
            }
            printFoo.run();
            fooTurn = false;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (fooTurn) {
                wait();
            }
            printBar.run();
            fooTurn = true;
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LC1115_PrintFooBarAlternately printer =
                new LC1115_PrintFooBarAlternately(3);

        Thread fooThread = new Thread(() -> {
            try { printer.foo(() -> System.out.print("foo")); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread barThread = new Thread(() -> {
            try { printer.bar(() -> System.out.print("bar")); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });

        fooThread.start();
        barThread.start();
        fooThread.join();
        barThread.join();
        System.out.println();
    }
}
