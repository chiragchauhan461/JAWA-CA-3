// LeetCode 509 - Fibonacci Number
// Java focus: static methods, recursion, method overloading (recursive + iterative)
class LC509_FibonacciNumber {
    // Recursive version: demonstrates recursion.
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // Overloaded method: iterative version with an additional parameter.
    public static int fib(int n, boolean useIteration) {
        if (!useIteration) {
            return fib(n);
        }
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(fib(6));        // 8 (recursive)
        System.out.println(fib(6, true));  // 8 (iterative)
    }
}
