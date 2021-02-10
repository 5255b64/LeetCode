package leetcode.num424;

/**
 * 424. Longest Repeating Character Replacement
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 * <p>
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 * <p>
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 * <p>
 * Note:
 * Both the string's length and k will not exceed 104.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "ABAB", k = 2
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s = "AABABBA", k = 1
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * <p>
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 */

/**
 * 解题思路：双指针（滑动窗口）
 * 使用两个指针来限定一个窗口
 * 使用一个长度为26的数组（全是大写字母）或者hashmap来统计每个字母的数量
 * 统计最多字符的数量 若非最多字符的数量正好为k 则得到一个临时结果
 * （如何快速统计最高值？）
 * 当非最多字符的数量小于等于k时 右指针右移
 * 当非最多字符的数量大于k时 左指针右移
 * 取所有临时结果的最大值作为最终结果
 *
 * 快速统计最高值：
 */
public class Solution {
    public int characterReplacement(String s, int k) {
        // 异常情况
        if (s.length() <= 0 || k < 0) {
            return 0;
        }

        int result = 0;
        char[] charList = s.toCharArray();
        // 双指针
        int ptrL = 0, ptrR = 0;
        // 统计每个字符在窗口中出现的次数
        int[] map = new int[26];
        // 最多字符的下标
        int maxIndex = charList[0] - 'A';
        // 最多字符数量
        int counterMax = 0;
        // 非最多字符数量
        int counterNotMax = 0;

        do {
            if (counterNotMax <= k) {
                // 当非最多字符的数量小于等于k时 右指针右移
                int objIndex = charList[ptrR] - 'A';
                map[objIndex]++;
                if (maxIndex == objIndex) {
                    counterMax++;
                } else {
                    counterNotMax++;
                }
                ptrR++;
            } else {
                // 当非最多字符的数量大于k时 左指针右移
                int objIndex = charList[ptrL] - 'A';
                map[objIndex]--;
                if (maxIndex == objIndex) {
                    counterMax--;
                } else {
                    counterNotMax--;
                }
                ptrL++;
            }
            // check max 重新寻找最大值
            if (counterMax < counterNotMax) {
                int max = 0;
                for (int i = 1; i < 26; i++) {
                    if (map[i] > map[max]) {
                        max = i;
                    }
                }
                maxIndex = max;
                counterNotMax = counterMax + counterNotMax - map[max];
                counterMax = map[max];
            }
            // 若非最多字符的数量正好为k 则得到一个临时结果
            if (counterNotMax <= k) {
                result = Math.max(result, ptrR - ptrL);
            }
        } while (ptrR < s.length());
        return result;
    }
}
