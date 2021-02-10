package leetcode.Num315;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 解法：    暴力求解
 * 执行结果： 超时
 */
public class Method1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间

        Solution1 solution = new Solution1();
        int[] input = new int[4];
        input[0] = 5;
        input[1] = 2;
        input[2] = 6;
        input[3] = 1;
        List<Integer> result = solution.countSmaller(input);
        System.out.println(result);

        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}

class Solution1 {
    public List<Integer> countSmaller(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int counter = 0;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    counter++;
                }
            }
            result[i]=counter;
        }
        List<Integer> resultList = new LinkedList<>();
        for(int i:result){
            resultList.add(i);
        }

        return resultList;
    }
}
