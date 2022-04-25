package week09_homework;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author HuChao
 * @date 2022/4/26/0026 0:32
 */
public class ShortestPathBinaryMatrix_BFS_TD {

    // 双向BFS  通过测试用例 84/88

    static int[] dx = new int[]{1, 0, 0, -1, 1, 1, -1, -1};
    static int[] dy = new int[]{0, -1, 1, 0, 1, -1, 1, -1};
    int n;
    int[][] grid;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        n = grid.length;
        if(grid[n - 1][n - 1] == 1) return -1;
        if(n == 1) return 1;
        this.grid = grid;
        Deque<Pair<Integer, Integer>> qBegin = new LinkedList<>();
        int[] dBegin = new int[n * n];
        Deque<Pair<Integer, Integer>> qEnd = new LinkedList<>();
        int[] dEnd = new int[n * n];

        dBegin[calc(0, 0, n)] = 1;
        dEnd[calc(n - 1, n - 1, n)] = 1;
        qBegin.add(new Pair<>(0, 0));
        qEnd.add(new Pair<>(n - 1, n - 1));

        boolean[][] vBegin = new boolean[n][n];
        boolean[][] vEnd = new boolean[n][n];
        vBegin[0][0] = true;
        vEnd[n - 1][n - 1] = true;

        while(!qBegin.isEmpty() || !qEnd.isEmpty()) {
            int res = expend(qBegin, dBegin, dEnd, vBegin);
            if(res != -1) return res;
            res = expend(qEnd, dEnd, dBegin, vEnd);
            if(res != -1) return res;
        }

        return -1;
    }

    int expend(Deque<Pair<Integer, Integer>> q, int[] depth, int[] depthOther, boolean[][] visted) {
        if(q.isEmpty()) return -1;

        Pair<Integer, Integer> curr = q.pop();
        int cx = curr.getKey();
        int cy = curr.getValue();
        for(int i = 0; i < 8; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n || visted[nx][ny] || grid[nx][ny] == 1) continue;

            if(depthOther[calc(nx, ny, n)] > 0) return depth[calc(cx, cy, n)] + depthOther[calc(nx, ny, n)];

            q.add(new Pair<>(nx, ny));
            depth[calc(nx, ny, n)] = depth[calc(cx, cy, n)] + 1;
            visted[nx][ny] = true;
        }

        return -1;
    }

    int calc(int x, int y, int n) {
        return x * n + y;
    }
}
