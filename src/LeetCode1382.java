import java.util.ArrayList;

public class LeetCode1382 {
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        appendNode(root, arr);

        TreeNode newRoot = reconstructNode(arr, 0, arr.size()-1);

        return newRoot;

    }

    public void appendNode(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        //System.out.println(root.val);


        appendNode(root.left, arr);
        arr.add(root.val);
        appendNode(root.right, arr);
    }

    public TreeNode reconstructNode(ArrayList<Integer> arr, int from, int to) {
        if (from > to) {
            return null;
        }


        int middle = (from + to) / 2;
        TreeNode root = new TreeNode(arr.get(middle));
        System.out.println(root.val);
        root.left = reconstructNode(arr, from, middle-1);
        root.right = reconstructNode(arr, middle+1, to);

        return root;

    }

    public class TreeNode { int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }}
}
