package test.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wenbo
 */
public class Tree {
    private int val;
    private Tree left;
    private Tree right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }


    public static void preTree(Tree root){
        if ( root != null){
            System.out.println( root.val + " ");
        }
        preTree(root.left);
        preTree(root.right);
    }

    public static void levelTree(Tree root){
        Queue<Tree> queue = new LinkedList();
        if (root == null){
            return;
        }
        queue.offer(root);
        while (queue.peek() != null){
            Tree t = queue.poll();
            System.out.println(t.val);
            if (t.left != null){
                queue.offer(t.left);
            }
            if (t.right != null){
                queue.offer(t.right);
            }
        }
    }

}
