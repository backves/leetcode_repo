public class Leetcode_11 {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int h = height[l] > height[r] ? height[r] : height[l];
            ans = Math.max(h * (r - l), ans);
            if (height[l] < height[r]) {
                while (l < r && height[l] <= h) ++l;
            } else {
                while (l < r && height[r] <= h) --r;
            }
        }
        return ans;
    }

    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }
}
