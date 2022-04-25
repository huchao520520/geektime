package week09_homework;

/**
 * 第四题
 *
 * @author HuChao
 * @date 2022/4/25/0025 22:58
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

}
