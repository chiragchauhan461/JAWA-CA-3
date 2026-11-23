// LeetCode 1 - Two Sum
// Java focus: HashMap, try-catch, throw IllegalArgumentException
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class LC001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        try {
            for (int i = 0; i < nums.length; i++) {
                int needed = target - nums[i];

                if (seen.containsKey(needed)) {
                    return new int[]{seen.get(needed), i};
                }
                seen.put(nums[i], i);
            }
            throw new IllegalArgumentException("No valid pair found.");
        } catch (IllegalArgumentException exception) {
            // Re-throw so the caller can handle the missing-pair case.
            throw exception;
        }
    }

    public static void main(String[] args) {
        LC001_TwoSum solution = new LC001_TwoSum();
        System.out.println(Arrays.toString(
                solution.twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
    }
}
