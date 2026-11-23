// LeetCode 1672 - Richest Customer Wealth
// Java focus: 2D arrays, nested loops, Math.max
class LC1672_RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int richestWealth = 0;

        for (int[] customer : accounts) {
            int total = 0;
            for (int money : customer) {
                total += money;
            }
            richestWealth = Math.max(richestWealth, total);
        }
        return richestWealth;
    }

    public static void main(String[] args) {
        LC1672_RichestCustomerWealth solution = new LC1672_RichestCustomerWealth();
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(solution.maximumWealth(accounts)); // 6
    }
}
