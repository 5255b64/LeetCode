package leetcode.Num100;


import org.junit.Test;
import org.testng.annotations.AfterTest;

import static org.junit.Assert.assertEquals;

class SolutionTest {
    @AfterTest
    public void test1(){
        Solution s = new Solution();
        TreeNode input1 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode input2 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        boolean output = s.isSameTree(input1,input2);
        boolean result = true;
        assertEquals(result, output);
    }

    @Test
    public void test2(){
        Solution s = new Solution();
        TreeNode input1 = new TreeNode(1,new TreeNode(2),null);
        TreeNode input2 = new TreeNode(1,null,new TreeNode(2));
        boolean output = s.isSameTree(input1,input2);
        boolean result = false;
        assertEquals(result, output);
    }

    @Test
    public void test3(){
        Solution s = new Solution();
        TreeNode input1 = new TreeNode(1,new TreeNode(2),new TreeNode(1));
        TreeNode input2 = new TreeNode(1,new TreeNode(1),new TreeNode(2));
        boolean output = s.isSameTree(input1,input2);
        boolean result = false;
        assertEquals(result, output);
    }
}