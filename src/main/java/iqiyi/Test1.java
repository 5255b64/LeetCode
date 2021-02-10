package iqiyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author jgz
 * @Date 2020-08-23 15:32
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(lengthOfLongestSubstring(in.next()));
    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1;
        int res = 0;
        for (int j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c));
            }
            map.put(c,j);
            res = Math.max(res, j-i);
        }
        return res;
    }
}
