public class LeetCode1214 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        return twoSumBSTsBruteForce(root1, root2, target);
    }

    public boolean twoSumBSTsBruteForce(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null && root2 == null) {
            return false;
        }

        if (root1 == null) {
            return findValue(root2, target);
        }

        if (root2 == null) {
            return findValue(root1, target);
        }



        TreeNode p = root1;
        if (findValue(root2, target-root1.val)) {
            return true;
        }

        return twoSumBSTsBruteForce(root1.left, root2, target) || twoSumBSTsBruteForce(root1.right, root2, target);
    }


    public static boolean findValue(TreeNode root, int target) {
        if (root == null) { return false; }

        int cmp = root.val - target;
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return findValue(root.right, target);
        } else {
            return findValue(root.left, target);
        }


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
