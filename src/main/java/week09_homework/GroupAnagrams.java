package week09_homework;

import java.util.*;

/**
 * 第十一题
 *
 * @author HuChao
 * @date 2022/4/25/0025 23:44
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            if (map.containsKey(calcHash(str))) {
                map.get(calcHash(str)).add(str);
            } else {
                List<String> newStrs = new ArrayList<>();
                newStrs.add(str);
                map.put(calcHash(str), newStrs);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

    public String calcHash(String str) {
        if (str == null || str.length() == 0) return "";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
