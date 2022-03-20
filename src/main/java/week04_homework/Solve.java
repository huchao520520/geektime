package week04_homework;


/**
 * 第一题 leetcode 130. 被围绕的区域
 *
 * @author HuChao
 * @date 2022/3/19/0019 22:58
 */
public class Solve {

    int m;
    int n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        // 从边缘O出发，深搜,标记能到达的所有'O'为'Q'
        for(int i = 0; i < m; i++) {
            dfs(i, 0, board);
            dfs(i, n - 1, board);
        }
        for(int i = 0; i < n; i++) {
            dfs(0, i, board);
            dfs(m - 1, i, board);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'Q') board[i][j] = 'O'; // 还原被标记的‘O’
                else if(board[i][j] == 'O') board[i][j] = 'X'; // 没有被标记的O即为被X包围的区域
            }
        }
    }

    void dfs(int x, int y, char[][] board) {
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'Q';
        dfs(x + 1, y, board);
        dfs(x - 1, y, board);
        dfs(x, y + 1, board);
        dfs(x, y - 1, board);
    }
}
