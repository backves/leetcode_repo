import java.util.Arrays;

public class Leetcode_88 {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, r = 0;
        int[] sorted = new int[m + n];
        while (i < m || j < n) {
            if (i == m) {
                sorted[r] = nums2[j++];
            } else if (j == n) {
                sorted[r] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                sorted[r] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sorted[r] = nums2[j++];
            }
            r++;
        }

        for (i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    void main() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
