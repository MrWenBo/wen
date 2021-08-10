package onLineCode.tree;

import onLineCode.struct.ListNode;
import onLineCode.struct.TreeNode;

import java.util.*;

/**
 * @author ：wenbo
 * @date ：Created in 2021/3/14 9:24 下午
 * @description：树的相关题目
 * @modified By：
 * @version: $
 */
public class Solution {

   /**
    * create by: Bo.W
    * description: 二叉树层序遍历
    * create time: 2021/3/23 9:25 上午
    *
    * params:
    * @return
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
    /**
     * create by: Bo.W
     * description: 序列化二叉树
     * create time: 2021/3/23 9:24 上午
     *
     * params:
     * @return
     */
    public String serialize(TreeNode root) {
        if(root == null){
            return "[]";
        }
        StringBuffer res = new StringBuffer("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){
                res.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    /**
     * create by: Bo.W
     * description: 反序列化
     * create time: 2021/3/23 9:24 上午
     *
     * params:
     * @return
     */
    public TreeNode deserialize(String data) {
        if(data.equals("[]")){
            return null;
        }
        String[] vals = data.substring(1,data.length() -1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(node.left);
            }
            i++;
            if (!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
    /**
     * create by: Bo.W
     * description: 对称二叉树
     * create time: 2021/3/15 3:26 下午
     * 
     * params:
     * @return 
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode l, TreeNode r){
        if(l == null && r == null){
            return true;
        }
        if(l == null || r == null || l.val != r.val){
            return false;
        }
        return recur(l.left, r.right) &&  recur(l.right, r.left);
    }

    /**
     * create by: Bo.W
     * description: 合并k路升序链表
     * create time: 2021/3/17 10:45 上午
     *
     * params:
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for(int i = 0; i < lists.length; i++){
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }
    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if(a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, apt = a, bpt = b;
        while(apt != null && bpt != null){
            if(apt.val < bpt.val){
                tail.next = apt;
                apt = apt.next;
            }else{
                tail.next = bpt;
                bpt = bpt.next;
            }
            tail = tail.next;
        }
        tail.next = apt != null ? apt : bpt;
        return head.next;
    }


    /**
     * create by: Bo.W
     * description: 重建二叉树
     * create time: 2021/3/23 9:26 上午
     *
     * params:
     * @return
     */
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

}
