package leetcode.Num17_13_ReSpaceLCCI;

/**
 * Oh, no! You have accidentally removed all spaces, punctuation, and capitalization in a lengthy document. A sentence like "I reset the computer. It still didn't boot!" became "iresetthecomputeritstilldidntboot''. You'll deal with the punctuation and capi­talization later; right now you need to re-insert the spaces. Most of the words are in a dictionary but a few are not. Given a dictionary (a list of strings) and the document (a string), design an algorithm to unconcatenate the document in a way that minimizes the number of unrecognized characters. Return the number of unrecognized characters.
 * <p>
 * Note: This problem is slightly different from the original one in the book.
 * <p>
 * Example:
 * <p>
 * Input:
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * Output:  7
 * Explanation:  After unconcatenating, we got "jess looked just like tim her brother", which containing 7 unrecognized characters.
 * Note:
 * <p>
 * 0 <= len(sentence) <= 1000
 * The total number of characters in dictionary is less than or equal to 150000.
 * There are only lowercase letters in dictionary and sentence.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/re-space-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

/**
 * 解题思路：使用字典树+动态规划
 *          字典树用于存储所有单词
 */

public class Method1 {
    public static void main(String[] args) {
        String[] dictionary = new String[5];
        dictionary[0] = "looked";
        dictionary[1] = "just";
        dictionary[2] = "like";
        dictionary[3] = "her";
        dictionary[4] = "brother";
        String sentence = "jesslookedjustliketimherbrother";
        Solution1 solution = new Solution1();
        int result = solution.respace(dictionary, sentence);
        System.out.println(result);
    }
}

class Solution1 {
    public int respace(String[] dictionary, String sentence) {
        Trie root = new Trie();
        root.init(dictionary);  // 倒序插入

        // DP
        int sentenceLength = sentence.length();
        int[] resultList = new int[sentenceLength + 1];

        Arrays.fill(resultList, Integer.MAX_VALUE);
        resultList[0] = 0;

        for (int i = 1; i < sentenceLength + 1; i++) {
            resultList[i] = resultList[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                String subStr = sentence.substring(j, i);
                if (root.checkWord(subStr)) {
                    resultList[i] = Math.min(resultList[j], resultList[i]);
                }
                if(resultList[i]==0){
                    break;  // 提前结束 提高执行效率
                }
            }
        }


        return resultList[sentenceLength];
    }
}

class Trie {
    public boolean isEnd;

    public Trie[] next;

    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    public void init(String[] dictionary) {
        for (String str : dictionary) {
            Trie ptr = this;
            // 倒序插入
            for (int i = str.length() - 1; i >= 0; i--) {
                int tmp = str.charAt(i) - 'a';
                if (ptr.next[tmp] == null) {
                    ptr.next[tmp] = new Trie();
                }
                ptr = ptr.next[tmp];
            }
            ptr.isEnd = true;
        }
    }

    public boolean checkWord(String word) {
        Trie ptr = this;
        for (int i = word.length() - 1; i >= 0; i--) {
            int tmp = word.charAt(i) - 'a';
            if (ptr.next[tmp] != null) {
                ptr = ptr.next[tmp];
            } else {
                return false;
            }
        }
        if (ptr.isEnd) {
            return true;
        } else {
            return false;
        }
    }
}

