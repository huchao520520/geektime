package week03_homework;

import java.util.*;

/**
 * 第四题 leetcode 210. 课程表 II
 *
 * @author HuChao
 * @date 2022/3/12/0012 23:09
 */
public class FindOrder {

    List<Integer>[] to;
    int[] inDeg;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 出边数组
        to = new List[numCourses];
        // 入度
        inDeg = new int[numCourses];
        // 构造出边数组，计算入度
        for(int[] pre : prerequisites) {
            int ai = pre[0];
            int bi = pre[1];
            List<Integer> t = to[bi];
            if(t == null) {t = new ArrayList<>(); t.add(ai); to[bi] = t;}
            else t.add(ai);
            inDeg[ai]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 有序变长数组/集合存储已修课程
        List<Integer> lessons = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            // 入度为零的课程直接入队列
            if(inDeg[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            // 出对列，加入已修集合
            int curr = queue.poll();
            lessons.add(curr);
            List<Integer> t = to[curr];
            if(t != null) {
                for(int s : t) {
                    inDeg[s]--; // 入度减一
                    if(inDeg[s] == 0) { // 入度为零表示可修，入队列
                        queue.add(s);
                    }
                }
            }
        }
        if(lessons.size() < numCourses) return new int[]{}; // 已修课程数小于总数
        int[] ans = new int[numCourses];
        for(int i = 0; i < numCourses; i++) ans[i] = lessons.get(i);
        return ans;
    }
}
