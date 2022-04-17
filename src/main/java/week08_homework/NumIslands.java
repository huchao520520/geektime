package week08_homework;

/**
 * 第二题 leetcode 200. 岛屿数量
 *
 * @author HuChao
 * @date 2022/4/17/0017 20:59
 */
public class NumIslands {

    int[] fa;
    int m,n;
    int ans;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        fa = new int[m * n];
        for(int i = 0; i < m * n; i++) fa[i] = i;
        ans = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0') continue;
                ans++; // 有一个岛屿答案加一， 合并一次答案减一
                // 走下、右两个方向，是岛屿则合并
                if (i+1 < m && grid[i+1][j] == '1') {
                    unionSet(num(i, j), num(i + 1, j));
                }
                if (j+1 <n && grid[i][j+1] == '1') {
                    unionSet(num(i, j), num(i, j + 1));
                }
            }
        }
        return ans;
    }

    int num(int i, int j) {
        return i * n + j;
    }

    int find(int x) {
        if(x == fa[x]) return x;
        return fa[x] = find(fa[x]);
    }

    void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            fa[x] = y;
            ans--;
        }
    }
}
