package leetcode.Num216;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */

/**
 * 解法：递归 将父问题化解为子问题求解
 * 当k=1时为最小的子问题 直接给出答案
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 || n <= 0) {
            // 无法满足的情况
            return new ArrayList<>();
        }
        // 递归求解
        List<List<Integer>> result = combinationSum3Recursion(k, n, 0);
        return result;
    }

    /**
     * 递归方法
     *
     * @param k
     * @param n
     * @param greaterThan 所选数必须大于该数
     * @return
     */
    public List<List<Integer>> combinationSum3Recursion(int k, int n, int greaterThan) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 1) {
            // 只需求解一个数 直接判断输出
            if (n > greaterThan && n <= 9) {
                List<Integer> tempList = new ArrayList<>();
                tempList.add(n);
                result.add(tempList);
            }
        } else if (n > greaterThan) {
            for (int i = greaterThan + 1; i <= 9; i++) {
                if (10 - i >= k) {
                    // 如果10-i>=k 则无法计算出有效解
                    List<List<Integer>> tempResult = combinationSum3Recursion(k - 1, n - i, i);
                    for (List<Integer> tempList : tempResult) {
                        // 若子问题有解 则父问题有解 插入父问题的中间结果
                        if (tempList.size() > 0) {
                            tempList.add(0, i);
                        }
                    }
                    result.addAll(tempResult);
                }
            }
        }
        // 递归求解子问题
        return result;
    }
}
