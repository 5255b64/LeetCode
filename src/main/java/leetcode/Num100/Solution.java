package leetcode.Num100;

/**
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 *
 * https://leetcode-cn.com/problems/same-tree/
 */

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null) {
            // 存在null的情况
            if (p == null && q == null) {
                // 都为null
                return true;
            } else {
                // 只有一个为null
                return false;
            }
        }else{
            if(p.val!=q.val){
                return false;
            }else {
                // 不存在null的情况
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}
