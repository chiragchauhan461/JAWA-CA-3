// LeetCode 41 - First Missing Positive
// Java focus: arrays, in-place modification, loops, control flow
class LC041_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each value x at index x - 1 whenever x is in [1, n].
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n
                    && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // The first index that does not contain index + 1 is the answer.
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        LC041_FirstMissingPositive solution = new LC041_FirstMissingPositive();
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0})); // 3
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1})); // 2
        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12})); // 1
    }
}
