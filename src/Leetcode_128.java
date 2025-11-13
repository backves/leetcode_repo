import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        nums = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);
        int len = 1;
        for (int left = 0; left < nums.length - 1; left++) {
            int right = left + 1;
            while (right < nums.length && nums[right] == nums[right - 1] + 1) {
                right++;
            }
            len = Math.max(len, right - left);
            left = right - 1;
        }
        return len;
    }

    void main() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }
}
