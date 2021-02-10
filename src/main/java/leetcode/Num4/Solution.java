package leetcode.Num4;

/*
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */

/**
 * 解题思路： 数组归并
 * //TODO 注：无法满足时间复杂度要求O(log (m+n)) 实际复杂度为O(m+n)
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ptr1 = 0, ptr2 = 0;
        int counter = (nums1.length + nums2.length+2) / 2;
        boolean isOdd = (nums1.length + nums2.length) % 2 == 1; // 是否为奇数
        double[] mergeList = new double[counter];
        for(int i=0;i<counter;i++){
            boolean is1=true;
            if(ptr1<nums1.length&&ptr2<nums2.length){
                if(nums1[ptr1]>nums2[ptr2]){
                    is1=false;
                }
            }else{
                if(ptr1>=nums1.length){
                    is1=false;
                }
            }
            if(is1){
                mergeList[i]=nums1[ptr1];
                ptr1++;
            }else{
                mergeList[i]=nums2[ptr2];
                ptr2++;
            }
        }
        if(isOdd){
            return mergeList[counter-1];
        }else{
            return (mergeList[counter-1]+mergeList[counter-2])/2;
        }
    }
}
