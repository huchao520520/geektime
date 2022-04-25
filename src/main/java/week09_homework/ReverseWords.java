package week09_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 第七题
 *
 * @author HuChao
 * @date 2022/4/25/0025 23:15
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = new ArrayList<>(Arrays.asList(s.split("\\s+")));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
