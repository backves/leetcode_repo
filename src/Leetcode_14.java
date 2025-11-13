public class Leetcode_14 {
    public String longestCommonPrefix1(String[] strs) {
        String pre = "";
        for (int i = 0; i < strs[0].length(); i++) {
            pre = strs[0].substring(0, i + 1);
            for (String s : strs) {
                if (!s.substring(0, Math.min(i + 1, s.length())).equals(pre)) {
                    return pre.substring(0, i);
                }
            }
        }
        return pre;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    void main() {
//        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs = new String[]{"ab", "a"};
//        String[] strs = new String[]{"a"};
        System.out.println(longestCommonPrefix(strs));
    }
}
