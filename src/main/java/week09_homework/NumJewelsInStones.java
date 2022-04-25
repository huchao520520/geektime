package week09_homework;

import java.util.HashSet;
import java.util.Set;

/**
 * 第三题
 *
 * @author HuChao
 * @date 2022/4/25/0025 22:51
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int ans = 0;
        for(int i = 0; i < stones.length(); i++) {
            if(set.contains(stones.charAt(i))) ans += 1;
        }
        return ans;
    }

}
