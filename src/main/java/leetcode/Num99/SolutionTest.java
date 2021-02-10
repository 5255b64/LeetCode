package leetcode.Num99;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1() {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        s.recoverTree(tree);
        assertEquals(3, tree.val);
        assertEquals(1, tree.left.val);
        assertEquals(null, tree.right);
        assertEquals(null, tree.left.left);
        assertEquals(2, tree.left.right.val);
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        TreeNode tree = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        s.recoverTree(tree);
        assertEquals(2, tree.val);
        assertEquals(1, tree.left.val);
        assertEquals(4, tree.right.val);
        assertEquals(3, tree.right.left.val);
        assertEquals(null, tree.right.right);
    }
}