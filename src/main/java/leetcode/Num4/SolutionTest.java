package leetcode.Num4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1(){
        Solution solution = new Solution();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double result = 2;
        double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(result, output);
    }

    @Test
    public void test2(){
        Solution solution = new Solution();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double result = 2.5;
        double output = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(result, output);
    }
}