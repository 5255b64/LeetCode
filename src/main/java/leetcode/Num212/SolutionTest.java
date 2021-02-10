package leetcode.Num212;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1() {
        Solution s = new Solution();
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board =
                {
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                };
        String[] resultExpected = {"eat", "oath"};
        List<String> resultListExpected = new ArrayList<String>();
        Collections.addAll(resultListExpected, resultExpected);
        System.out.println(resultListExpected);
        List<String> result = s.findWords(board, words);
        Collections.sort(resultListExpected);
        Collections.sort(result);
        assertEquals(resultListExpected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            assertEquals(resultListExpected.get(i), result.get(i));
        }
    }
}