package week09_homework;

/**
 * 第十二题
 *
 * @author HuChao
 * @date 2022/4/25/0025 23:55
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        // 初值
        for(int i = 1; i <= m; i++) {
            if(p.charAt(i) == '*') f[0][i] = true;
            else break;
        }
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 转移
                if (p.charAt(j) == '*') {
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
                } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    f[i][j] = f[i - 1][j - 1];
                }
            }
        }
        return f[n][m];
    }
}
