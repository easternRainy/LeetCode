public class LeetCode538 {
    //     public TreeNode convertBST(TreeNode root) {
//         if (root == null) {
//             return null;
//         }


//         TreeNode gst = new TreeNode();

//         TreeNode convertRight = convertBST(root.right);
//         TreeNode convertLeft = convertBST(root.left);
//         int rightVal = (convertRight == null) ? 0 : convertRight.val;
//         int leftVal = (convertLeft == null) ? 0: convertLeft.val;

//         gst.right = convertRight;
//         gst.val = root.val + findLeftMost(convertRight);

//         gst.left = addValue(convertLeft, gst.val);

//         return gst;
//     }

//     public TreeNode addValue(TreeNode root, int val) {
//         // add val to each node
//         if (root == null) {
//             return null;
//         }

//         root.val = root.val + val;
//         root.left = addValue(root.left, val);
//         root.right = addValue(root.right, val);
//         return root;
//     }

//     public int findLeftMost(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         TreeNode p = root;
//         while(p.left != null) {
//             p = p.left;
//         }

//         return p.val;
//     }


    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }

        return root;
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
