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
 * {更优解}
 * 解题思路：双指针（滑动窗口）
 * 使用两个指针来限定一个窗口
 * 窗口大小不会降低 而会增大
 * 使用一个长度为26的数组（全是大写字母）或者hashmap来统计每个字母的数量
 * 若窗口内满足非最大值数量小于等于k 则右指针右移
 * 若不满足 则左指针左移 并且右指针右移
 * <p>
 * 每次右移右指针 新进入窗口的值可能成为最大值 要进行比较
 */
public class SolutionBetter {
    public int characterReplacement(String s, int k) {
        // 双指针
        int ptrL = 0, ptrR = 0;
        // 统计每个字符在窗口中出现的次数
        int[] map = new int[26];
        // 最多字符的下标
        int maxIndex = 0;

        while (ptrR < s.length()) {
            // 计算新的最大值
            map[s.charAt(ptrR) - 'A']++;
            int temp = s.charAt(ptrR) - 'A';
            if (map[temp] > map[maxIndex]) {
                maxIndex = temp;
            }
            // 判断左指针是否需要右移
            if (ptrR - ptrL + 1 - map[maxIndex] > k) {
                map[s.charAt(ptrL) - 'A']--;
                ptrL++;
            }
            // 右指针右移
            ptrR++;
        }
        return ptrR - ptrL;
    }
}
