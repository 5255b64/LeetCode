package leetcode.Num6;

/*
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */

/**
 * 解题思路： 找规律
 */
public class Solution {
    public String convert(String s, int numRows) {
        char[] str = s.toCharArray();
        int strLen = s.length();
        int cycle;  // 周期
        char[] result = new char[strLen];
        int charPtr=0;
        if (numRows <= 1) {
            cycle = 1;
        } else {
            cycle = numRows * 2 - 2;
        }

        // 根据周期来输出
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                // 输出每个周期第1个数
                for (int j = 0; j < strLen; j += cycle) {
                    result[charPtr]=str[j];
                    charPtr++;
                }

            } else if (i < numRows - 1) {
                // 输出每个周期 第i个数 以及第cycle-i个数
                for (int j = 0; j*cycle + i < strLen; j++) {
                    // 第i+1个数
                    result[charPtr]=str[j*cycle+i];
                    charPtr++;
                    // 第cycle-i个数
                    if (j*cycle+cycle-i < strLen) {
                        result[charPtr]=str[j*cycle+cycle-i];
                        charPtr++;
                    }
                }
            } else {
                // 输出每个周期 第numRows个数
                for (int j = numRows - 1; j < strLen; j += cycle) {
                    result[charPtr]=str[j];
                    charPtr++;
                }
            }
        }
        return new String(result);
    }
}
