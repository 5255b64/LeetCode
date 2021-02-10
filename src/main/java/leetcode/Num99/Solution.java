package leetcode.Num99;

import java.util.*;

/**
 * 99. Recover Binary Search Tree
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * Output: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * Example 2:
 * <p>
 * Input: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * <p>
 * Output: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 * /
 * 3
 * Follow up:
 * <p>
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 * <p>
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 */

/**
 * 解题思路： 中序遍历
 *          然后重排序
 *          比较重排序前后有哪两个值发生了变化
 *          最后将变化的两个值进行交换
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> mftList = MFT(root);
        List<Integer> sortList = new ArrayList<>(mftList);
        Collections.sort(sortList);
        int swap1 = -1;
        int swap2 = -1;
        boolean flag = false;
        for (int i = 0; i < mftList.size(); i++) {
            if (mftList.get(i) != sortList.get(i)) {
                if (!flag) {
                    swap1 = mftList.get(i);
                    flag = true;
                }else {
                    swap2=mftList.get(i);
                    break;
                }
            }
        }
        Map<Integer, TreeNode> map = getMap(root);
        int temp = map.get(swap1).val;
        map.get(swap1).val=map.get(swap2).val;
        map.get(swap2).val=temp;
    }

    public Map<Integer, TreeNode> getMap(TreeNode root) {
        Map<Integer, TreeNode> result = new HashMap<>();
        Map<Integer, TreeNode> left, right;
        if (root == null) {
            return result;
        }
        left = getMap(root.left);
        right = getMap(root.right);
        result.put(root.val, root);
        result.putAll(left);
        result.putAll(right);
        return result;
    }

    public List<Integer> MFT(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> left, right;
        if (root == null) {
            return result;
        }
        left = MFT(root.left);
        right = MFT(root.right);
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }
}
