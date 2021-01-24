import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class LeetCode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<>();
        if (root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        for(String s: left) {
            result.add(Integer.toString(root.val) + "->" + s);
        }

        for(String s: right) {
            result.add(Integer.toString(root.val) + "->" + s);
        }

        return result;

    }

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