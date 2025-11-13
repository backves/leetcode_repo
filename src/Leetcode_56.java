import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.isEmpty() || merged.getLast()[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    void main() {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 17}, {15, 18}};
        int[][] merge = merge(intervals);

        for (int[] m : merge) {
            System.out.println(Arrays.toString(m));
        }
    }
}
