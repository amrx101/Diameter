/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class binarySearchTree {
    
    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode(int data){
            this.data = data;
        }
    }
    
    private TreeNode root;
    public binarySearchTree(){};
    
    public void inOrder(){
        inOrder(root);
        System.out.println("");
    }
    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    public void convert2ChildSum(){
        convert2childSum(root);
        
        
    }
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        return 1+Math.max(lHeight, rHeight);
    }
    public void getDiameter(){
        int diameter = diameter(root);
        System.out.println("The diameter of the tree is "+diameter);
    }
    
    
    private int diameter(TreeNode root){
        // base case , when no tree
        if(root == null){
            return 0;
        }
        /*
         * now, we have three choices ,
         * Diameter of left Subtree
         * Diameter of right Subtree
         * Longest leaf root distance in left sub tree + longest leaf root distance in right sub tree + 1
         * Diameter of the tree will be the maximum of these 3 quantities 
         */
        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);
        int lHeight = getHeight (root.left);
        int rHeight = getHeight (root.right);
        int height = lHeight + rHeight +1;
        return Math.max(height, Math.max(lDiameter, rDiameter));
        
        
    }
    private void convert2childSum(TreeNode root){
        if(root == null){
            return ;
        }
        else if (isLeaf(root)){
            return ;
        }
        else{
            convert2childSum(root.left);
            convert2childSum(root.right);
        }
        
        if(root.left != null && root.right != null){
            root.data = root.left.data + root.right.data;
        }
        else if(root.left == null && root.right != null){
            root.data = root.right.data;
        }
        else if(root.left != null && root.right == null){
            root.data = root.left.data;
        }
        else{
        }
    }
    private boolean isLeaf(TreeNode root){
        return (root.left == null && root.right == null);
    }
    public void insert(int data){
        root = insert(root,data);
    }
    private TreeNode insert(TreeNode root, int data){
        if(root == null){
            return new TreeNode(data);
        }
        else if (root.data > data){
            root.left = insert(root.left,data);
        }
        else if(root.data < data){
            root.right = insert(root.right,data);
        }
        else {};
        return root;
    }
}
