package leetcode.Num154;
/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * The array may contain duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 * <p>
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 解题思路： 使用二分查找
 */
public class Solution2 {
    public int findMin(int[] nums) {
        int result = findMinMerge(nums, 0, nums.length - 1);
        if (result == Integer.MIN_VALUE) {
            result = nums[0];
        }
        return result;
    }

    /**
     * 二分查找
     * 最小值所在的区间 满足 [区间最左端]<=[区间最右端]
     *
     * @param nums
     * @param from
     * @param to
     * @return
     */
    public int findMinMerge(int[] nums, int from, int to) {
        if (from == to) {
            return Integer.MIN_VALUE;
        }
        if (nums[from] >= nums[to]) {
            // 判断区间长度
            if (to - from == 1) {
                return nums[to];
            }
            // 满足条件 最小值在该区间内
            // 二分查找
            int mid = (from + to + 1) / 2;
            int leftReturn = findMinMerge(nums, from, mid);
            int rightReturn = findMinMerge(nums, mid, to);
            if (leftReturn > Integer.MIN_VALUE && rightReturn > Integer.MIN_VALUE) {
                return Math.min(leftReturn, rightReturn);
            } else if (leftReturn > Integer.MIN_VALUE) {
                return leftReturn;
            } else if (rightReturn > Integer.MIN_VALUE) {
                return rightReturn;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
