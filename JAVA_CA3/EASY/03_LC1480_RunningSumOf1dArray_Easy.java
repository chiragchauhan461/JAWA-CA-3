// LeetCode 1480 - Running Sum of 1d Array
// Java focus: 1D arrays, loops, in-place modification
import java.util.Arrays;

class LC1480_RunningSumOf1dArray {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        LC1480_RunningSumOf1dArray solution = new LC1480_RunningSumOf1dArray();
        System.out.println(Arrays.toString(solution.runningSum(
                new int[]{1, 2, 3, 4}))); // [1, 3, 6, 10]
    }
}
