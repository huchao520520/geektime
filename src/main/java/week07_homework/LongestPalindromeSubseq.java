package week07_homework;

/**
 * 第四题 leetcode 516. 最长回文子序列
 *
 * @author HuChao
 * @date 2022/4/10/0010 22:51
 */
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // f[i][j] 表示s[i ~ j]子串最长的回文序列长度
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1; // 初始化, 单个字符串时长度为1
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) { // 相同
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else { // 不同
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

}
