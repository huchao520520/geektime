package week02_homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第一题 leetcode 811. 子域名访问计数
 *
 * @author HuChao
 * @date 2022/3/6/0006 21:18
 */
public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {
        // Map<域名，被访问次数>
        Map<String, Integer> map = new HashMap<>();
        for(String domain : cpdomains) {
            String[] strs = domain.split(" ");
            int times = Integer.parseInt(strs[0]);
            String doma = strs[1];
            String[] strs2 = doma.split("\\.");
            put(map, doma, times);
            if (strs2.length == 3) {
                String first = strs2[2];
                String second = strs2[1] + "." + strs2[2];
                put(map, first, times);
                put(map, second, times);
            } else if (strs.length == 2) {
                String first = strs2[1];
                put(map, first, times);
            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }

    public void put(Map<String, Integer> map, String domain, int times) {
        if (map.containsKey(domain)) {
            map.put(domain, map.get(domain) + times);
        } else {
            map.put(domain, times);
        }
    }
}
