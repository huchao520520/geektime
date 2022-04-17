package week08_homework;

/**
 * 第一题 leetcode 684. 冗余连接
 *
 * @author HuChao
 * @date 2022/4/17/0017 20:58
 */
public class FindRedundantConnection {

    int[] fa;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        fa = new int[n + 1];
        for (int i = 0; i <= n; i++) fa[i] = i;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (find(x) != find(y)) unionSet(x, y);
            else return edge;
        }
        return new int[0];
    }

    int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) fa[x] = y;
    }

}
