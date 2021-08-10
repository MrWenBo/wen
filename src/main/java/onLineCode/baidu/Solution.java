package onLineCode.baidu;

import onLineCode.struct.TreeNode;

import java.util.*;

/**
 * @author ：wenbo
 * @date ：Created in 2021/1/30 11:09 上午
 * @description：百度面试题
 * @modified By：
 * @version: $1.0.0
 */
public class Solution {
        public static void main(String[] args) {
           // (    )   {   }    [   ]
            String s = "{[]}";
            System.out.println(isKuhao(s));
        }
        public static boolean isKuhao(String s){
            Stack<Character> stack = new Stack<>();
            for (char schar : s.toCharArray()) {
                if (schar == '(' || schar == '[' || schar == '{'){
                    stack.push(schar);
                } else if(!stack.empty() && schar == ')' && stack.peek() == '('){
                    stack.pop();
                } else if(!stack.empty() && schar == ']' && stack.peek() == '['){
                    stack.pop();
                } else if(!stack.empty() && schar == '}' && stack.peek() == '{'){
                    stack.pop();
                } else{
                    return false;
                }
            }
            return stack.empty();
        }

        public static List<List<Integer>> levelOrder(TreeNode root){
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null){
                return res;
            }
            queue.offer(root);
            while(!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
                res.add(list);
            }
            return res;
        }
}
