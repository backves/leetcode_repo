public class Leetcode_704 {
    public int search(int[] nums, int target) {

        return divide(nums, 0, nums.length - 1, target);
    }

    public int divide(int[] nums, int l, int r, int target) {
        if (l >= r) {
            return nums[l] == target ? l : -1;
        }
        int mid = (r - l) / 2 + l;
        if (nums[mid] == target) {
            return (r - l) / 2 + l;
        } else if (nums[mid] < target) {
            return divide(nums, mid + 1, r, target);
        } else {
            return divide(nums, l, mid - 1, target);
        }
    }

    void main() {
        int[] nums = new int[]{2, 5};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
