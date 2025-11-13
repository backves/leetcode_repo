public class Leetcode_121 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = 10000;
        for (int x : prices) {
            ans = Math.max(ans, x - min);
            if (x < min) min = x;
        }
        return ans;
    }

    void main() {
        int[] prices = new int[]{7, 2, 8, 3, 1, 4};
        System.out.println(maxProfit(prices));
    }
}
