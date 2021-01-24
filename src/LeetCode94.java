import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2020-08-20
 * Leet Code problem 94
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        while(p != null || !stack.empty()) {
            while(p != null) {
                stack.push(p);
                p = p.left;
            }

            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            p = tmp.right;

        }

        return result;

    }

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
