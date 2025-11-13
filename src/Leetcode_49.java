import java.util.*;

public class Leetcode_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);

            String sorted = new String(chars);

            List<String> list = map.get(sorted);

            if (list != null) {
                list.add(strs[i]);
            } else {
                list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}

