package week10_homework;

import java.util.*;

/**
 * 第二题 AcWing 136. 邻值查找
 *
 * @author HuChao
 * @date 2022/5/1/0001 11:03
 */
public class FindNeighbor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int curr = scan.nextInt();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(curr, 1);
        int ansKey ,ansValue;
        for(int i = 2; i <= n; i++) {
            ansKey = Integer.MAX_VALUE;
            ansValue = 0;
            curr = scan.nextInt();
            treeMap.put(curr, i);
            Map.Entry<Integer, Integer> pre = treeMap.lowerEntry(curr); // 前驱
            Map.Entry<Integer, Integer> next = treeMap.higherEntry(curr); // 后继
            if (next != null) {
                ansKey = next.getKey() - curr;
                ansValue = next.getValue();
            }
            if(pre != null && ansKey >= curr - pre.getKey()) {
                ansKey = curr - pre.getKey();
                ansValue = pre.getValue();
            }
            System.out.println(ansKey + " " + ansValue);
        }
    }
}
