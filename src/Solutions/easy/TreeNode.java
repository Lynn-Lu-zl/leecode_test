package Solutions.easy;

/**
 * 二叉树结构
 */
public class TreeNode {
    public int val;
    //左子树
    public TreeNode left;
    //右子树
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {


        //构造二叉树1
         TreeNode tree1 = new TreeNode(1);
         //第一层左右子树
         tree1.left = new TreeNode(2);
         tree1.right = new TreeNode(3);
         //第二层左子树的左子树
         tree1.left.left= new TreeNode(4);
         //第二层左子树的右子树
         tree1.left.right = new TreeNode(5);
         //第二层右子树的左子树
         tree1.right.left = new TreeNode(6);
         //第二层右子树的右子树
         tree1.right.right = new TreeNode(7);

         //构造二叉树2
         TreeNode tree2 = new TreeNode(1);
         //表示左子树空节点，q = [1,null,2]
         tree2.left = new TreeNode();
         tree2.right = new TreeNode(2);

    }
}
