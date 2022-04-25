package week09_homework;

/**
 * 第五题
 *
 * @author HuChao
 * @date 2022/4/25/0025 23:09
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int m = strs[0].length();
        int n = strs.length;
        for(int i = 0; i < m; i++) {
            char ch = strs[0].charAt(i);
            for(int j = 1; j < n; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != ch) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

}
