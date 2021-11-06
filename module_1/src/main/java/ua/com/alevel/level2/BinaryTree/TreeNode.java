package ua.com.alevel.level2.BinaryTree;

public class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(int x){
        val = x;
    }


    public TreeNode(int value, TreeNode nL, TreeNode nR){
        val = value;
        left = nL;
        right = nR;
    }


    public int getValue(){
        return val;
    }

    public TreeNode getLeft(){
        return left;
    }


    public TreeNode getRight(){
        return right;
    }


    public void setLeft(TreeNode n){
        left = n;
    }


    public void setRight(TreeNode n){
        right = n;
    }

}
