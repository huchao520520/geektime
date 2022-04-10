package week07_homework;

/**
 * 第一题 leetcode 279. 完全平方数
 *
 * @author HuChao
 * @date 2022/4/10/0010 22:00
 */
public class NumSquares {

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int min = 10001;
            for(int j = 1; j * j <= i; j++) {
                min = Math.min(min, f[i - j * j]);
            }
            f[i] = min + 1;
        }
        return f[n];
    }

}
