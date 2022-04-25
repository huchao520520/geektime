package week09_homework;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 第十三题
 *
 * @author HuChao
 * @date 2022/4/26/0026 0:18
 */
public class ShortestPathBinaryMatrix_BFS {

    static int[] dx = new int[]{1, 0, 0, -1, 1, 1, -1, -1};
    static int[] dy = new int[]{0, -1, 1, 0, 1, -1, 1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        if(n == 1) return 1;
        Deque<Pair<Integer, Integer>> q = new LinkedList<>();
        int[] depth = new int[n * n];
        depth[calc(0, 0, n)] = 1;
        boolean[][] visted = new boolean[n][n];
        visted[0][0] = true;
        q.add(new Pair<>(0, 0));
        while(!q.isEmpty()) {
            Pair<Integer, Integer> curr = q.pop();
            int cx = curr.getKey();
            int cy = curr.getValue();
            for(int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visted[nx][ny] || grid[nx][ny] == 1) continue;
                if(nx == n - 1 && ny == n - 1) return depth[calc(cx, cy, n)] + 1;
                q.add(new Pair<>(nx, ny));
                depth[calc(nx, ny, n)] = depth[calc(cx, cy, n)] + 1;
                visted[nx][ny] = true;
            }
        }
        return -1;
    }

    int calc(int x, int y, int n) {
        return x * n + y;
    }
}
