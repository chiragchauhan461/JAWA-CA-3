// LeetCode 1281 - Subtract the Product and Sum of Digits of an Integer
// Java focus: while loop, arithmetic operators, identifiers
class LC1281_SubtractProductAndSumOfDigits {
    public int subtractProductAndSum(int n) {
        int digitSum = 0;
        int digitProduct = 1;

        while (n > 0) {
            int digit = n % 10;
            digitSum += digit;
            digitProduct *= digit;
            n /= 10;
        }
        return digitProduct - digitSum;
    }

    public static void main(String[] args) {
        LC1281_SubtractProductAndSumOfDigits solution =
                new LC1281_SubtractProductAndSumOfDigits();
        System.out.println(solution.subtractProductAndSum(234)); // 15
        System.out.println(solution.subtractProductAndSum(4421)); // 21
    }
}
