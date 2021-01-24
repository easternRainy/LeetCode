import java.util.Stack;

/**
 * LeetCode problem 101
 * https://leetcode.com/problems/symmetric-tree/
 * Tags: #Tree
 *
 *
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }

        if(t1 != null && t2 == null) {
            return false;
        }

        if(t1 == null && t2 != null) {
            return false;
        }

        if(t1.val != t2.val) {
            return false;
        }


        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    /**
     * Not finished, reference LeetCode 94
     * @param root
     * @return
     */
    public boolean isSymmetricIteral(TreeNode root) {

        TreeNode pl = root;
        Stack<TreeNode> stackL = new Stack<>();

        TreeNode pr = root;
        Stack<TreeNode> stackR = new Stack<>();

        while(pl != null || pr != null || !stackL.empty() || !stackR.empty()) {
            while(pl != null) {
                stackL.push(pl);
                pl = pl.left;
            }

            while(pr != null) {
                stackR.push(pr);
                pr = pr.right;
            }

            TreeNode tmpL = stackL.pop();
            TreeNode tmpR = stackR.pop();

            if(tmpL == root && tmpR == root) {
                return true;
            }

            if(tmpL == null && tmpR != null) {
                return false;
            }

            if(tmpL != null && tmpR == null) {
                return false;
            }

            if(tmpL.val != tmpR.val) {
                return false;
            }

            pl = tmpL.right;
            pr = tmpR.left;
        }

        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


