
package onLineCode.leetcode;

import onLineCode.struct.ListNode;
import onLineCode.struct.TreeNode;

import java.util.*;


/**
 * @author wenbo
 */
public class Solution{

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1){
            return root;
        }
        int L = 0;
        for (int i = 0; i < N; i++) {
            if (post[i] == pre[1]){
                L = i + 1;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre,1,L+1),Arrays.copyOfRange(post,0,L));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre,L+1,N),Arrays.copyOfRange(post,L,N-1));
        return root;
    }


    public TreeNode sortedListToBST(ListNode head) {
        return buileTree(head,null);
    }
    public TreeNode buileTree(ListNode left, ListNode right){
        if (left == right){
            return null;
        }
        ListNode mid = getMedian(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buileTree(left,mid);
        root.right = buileTree(mid.next,right);
        return root;
    }
    public ListNode getMedian(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    private static  long Fun(int n)
    {
        if (n == 0 || n == 1) {
            return 1;
        }
        long res = 1;
        if( n > 2 )
        {
            res = Fun(n-1)+Fun(n-2);
        }
        return res;
    }
    private static  long Fun2(int n)
    {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1, b = 0;
        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
        }
        return a;
    }

    public int hammingWeight(int n) {

        return Integer.bitCount(n);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }

    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int lenth = 2 * numRows - 2;
        int n = s.length();
        StringBuffer res = new StringBuffer();

        for (int i = 0; i < numRows; i++){
            for (int j = 0; j + i < n; j += lenth ){
                res.append(s.charAt(i+j));
                if (i != 0 && i != numRows-1 && j + lenth - i < n){
                    res.append(s.charAt(j + lenth - i ));
                }
            }
        }
        return res.toString();
    }


    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? sumOfLeftDFS(root) : 0;
    }
    public int sumOfLeftDFS(TreeNode node){
        int res = 0;
        if (node.left != null){
            return res += isLeafNode(node.left) ? node.left.val : sumOfLeftDFS(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)){
             res += sumOfLeftDFS(node.right);
        }
        return res;
    }

    public boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }

}

