import java.util.Arrays;

public class Leetcode_283 {

    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    void main() {
        int[] nums = new int[]{0, 1, 2, 0, 3};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
