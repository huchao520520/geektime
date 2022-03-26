package week05_homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第二题 leetcode 911. 在线选举
 *
 * @author HuChao
 * @date 2022/3/25/0025 20:42
 */
public class TopVotedCandidate {

    private Map<Integer, Integer> votes; // 统计票数<候选人idx，票数>
    private List<Integer> tops; // tops.get(i) 为 i 时刻票数最高的人
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        tops =  new ArrayList<>();
        votes = new HashMap<>();
        votes.put(-1, -1);
        int top = -1;
        for(int i = 0; i < persons.length; i++) {
            int person = persons[i];
            votes.put(person, votes.getOrDefault(person, 0) + 1); // 更新该候选人票数
            top = votes.get(person) >= votes.get(top) ? person : top; // 该时刻票数最大值候选人
            tops.add(top);
        }
        this.times = times;
    }

    public int q(int t) {
        // t时刻票数最多的候选人|最近投票
        // times数组中 小于t的最大值
        int left = 0, right = times.length - 1;
        while(left < right) {
            int mid = (left + right + 1) >> 1;
            if(times[mid] <= t) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return tops.get(right);
    }

}
