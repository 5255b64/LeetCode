package leetcode.Num315;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1,5,2,6,1]
 * Output: [4,2,4,0,2,1,1,0]
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
 * 解法： 插入排序
 *       从后往前选择数 插入一个数列中
 *       根据插入的数在数列中的位置 可以知道比它小的数有几个
 * 结果： 超时
 */
public class Method2 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();   //获取开始时间

        Solution2 solution = new Solution2();
        int[] input = new int[8];
        input[0] = 5;
        input[1] = 2;
        input[2] = 6;
        input[3] = 1;
        input[4] = 5;
        input[5] = 2;
        input[6] = 6;
        input[7] = 1;
        List<Integer> result = solution.countSmaller(input);
        System.out.println(result);

        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}

class Solution2 {
    public List<Integer> countSmaller(int[] nums) {
        int[] result = new int[nums.length];
        CompareList root = new CompareList(Integer.MIN_VALUE);

        for(int i=nums.length-1;i>=0;i--){
            result[i] = root.insert(nums[i]);
//            System.out.println(root);
        }

        List<Integer> resultList = new LinkedList<>();
        for(int i:result){
            resultList.add(i);
        }

        return resultList;
    }
}

// 一个链表
class CompareList{
    CompareList next;   // 指向下一个节点
    int value;            // 节点保存的值

    public CompareList(int value){
        next=null;
        this.value=value;
    }

    /**
     * 插入一个值value
     * 返回比它小的值的个数
     * @param value
     * @return
     */
    int insert(int value){
        if(next!=null){
            // next不为null的情况
            if(this.next.value<value){
                return this.next.insert(value) +1;
            }else{
                // 插入节点
                CompareList tmp = new CompareList(value);
                tmp.next=this.next;
                this.next=tmp;
                return 0;
            }
        }else{
            // next不为null的情况
            // 插入的数比所有数都要大
            this.next = new CompareList(value);
            return 0;
        }

    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.value);
        if (next != null) {
            result.append(","+next.toString());
        }
        return result.toString();
    }
}
