public class Leetcode_53 {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    void main() {
        int[] nums = new int[]{-2, -1, 2, 3, -1, 1, 4};
        System.out.println(maxSubArray(nums));
    }
}
