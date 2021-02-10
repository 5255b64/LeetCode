package leetcode.Num576;

/**
 * 567. Permutation in String
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * <p>
 * https://leetcode-cn.com/problems/permutation-in-string/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：滑动窗口法
 * <p>
 * 根据s1中包含的字符数num 划定一个长度为num的窗口
 * 比较窗口中的每个字符的数量 是否与s1中每个字符的数量相同
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 使用哈希表来统计
        Map<Character, Integer> mapS1 = new HashMap<>();
        Map<Character, Integer> mapWindow = new HashMap<>();
        int windowSize = s1.length();
        // 异常情况
        if(windowSize>s2.length()){
            return false;
        }
        // 哈希表初始化
        for (int ptr = 0; ptr < windowSize; ptr++) {
            // s1哈希表
            char c = s1.charAt(ptr);
            if (mapS1.containsKey(c)) {
                mapS1.put(c, mapS1.get(c) + 1);
            } else {
                mapS1.put(c, 1);
            }
            // 窗口哈希表
            c = s2.charAt(ptr);
            if (mapWindow.containsKey(c)) {
                mapWindow.put(c, mapWindow.get(c) + 1);
            } else {
                mapWindow.put(c, 1);
            }
        }
        // 窗口滑动
        for (int ptr = 0; ptr <= s2.length() - windowSize; ptr++) {
            // 先比较
            boolean flag = true;
            for (Character c : mapS1.keySet()) {
                if (!mapWindow.containsKey(c) || !mapWindow.get(c).equals(mapS1.get(c))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            // 再滑动
            if (ptr < s2.length() - windowSize) {
                char c = s2.charAt(ptr);
                mapWindow.put(c, mapWindow.get(c) - 1);
                c = s2.charAt(ptr + windowSize);
                if (mapWindow.containsKey(c)) {
                    mapWindow.put(c, mapWindow.get(c) + 1);
                } else {
                    mapWindow.put(c, 1);
                }
            }
        }
        // 在s2中找不到s1的子排列
        return false;
    }
}
